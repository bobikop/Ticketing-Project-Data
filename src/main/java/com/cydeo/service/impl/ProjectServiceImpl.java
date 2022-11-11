package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.User;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.service.ProjectService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        Project project = projectRepository.findByProjectCode(code);
       return projectMapper.convertToDto(project);
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project>  list = projectRepository.findAll(Sort.by("projectCode"));
        return  list.stream()
                .map(project -> projectMapper.convertToDto(project))
                .collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO dto) {
//        Project project = projectMapper.convertToEntity(dto);
//        projectRepository.save(project);
        dto.setProjectStatus(Status.OPEN);
        projectRepository.save(projectMapper.convertToEntity(dto));
    }

    @Override
    public void update(ProjectDTO dto) {

        //day 3 : 12 explanation (setting the id before saving) pull from db get id set id save in db
        Project project = projectRepository.findByProjectCode(dto.getProjectCode()); // go to Db and get DTO
        Project convertedProject = projectMapper.convertToEntity(dto); // converted to entity
        convertedProject.setId(project.getId()); // getting id form the project, project.getId() and set it to converted project
        convertedProject.setProjectStatus(project.getProjectStatus());  // setting the status since is not in the form
        projectRepository.save(convertedProject);

    }

    @Override
    public void delete(String code) {
        Project project = projectRepository.findByProjectCode(code);
        project.setIsDeleted(true);
        projectRepository.save(project);
    }

    @Override
    public void complete(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }


}