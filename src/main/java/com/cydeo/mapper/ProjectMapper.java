package com.cydeo.mapper;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    private ModelMapper modelMapper;

    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Project convertToEntity(ProjectDTO dto) {
        return modelMapper.map(dto, Project.class);

    }

    public ProjectDTO convertToDto(Project entity) {
        return modelMapper.map(entity, ProjectDTO.class); // (source, target)  what is converted to what
    }
}
