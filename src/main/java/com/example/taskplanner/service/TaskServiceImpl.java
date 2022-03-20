package com.example.taskplanner.service;

import com.example.taskplanner.model.Task;
import com.example.taskplanner.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public String createTask(@NonNull Task task) {
        taskRepository.createTask(task);
        return task.getTaskId();
    }

    @Override
    public Task getTask(@NonNull String taskId) {
        return taskRepository.getTask(taskId);
    }

    @Override
    public void updateTaskStatus(@NonNull String taskId, @NonNull String status) {
        Task task = taskRepository.getTask(taskId);
        task.setStatus(status);
        taskRepository.updateTask(task);
    }
}
