package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

 private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        return null;
    }

    @Override
    public void save(TaskDTO dto) {

    }

    @Override
    public void update(TaskDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TaskDTO findById(Long id) {
        return null;
    }
}
