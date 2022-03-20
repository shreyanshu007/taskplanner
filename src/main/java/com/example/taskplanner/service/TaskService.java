package com.example.taskplanner.service;

import com.example.taskplanner.model.Task;
import org.springframework.lang.NonNull;

public interface TaskService {

    /**
     * To create new Task
     *
     * @param task
     * @return taskId
     */
    String createTask(@NonNull Task task);

    Task getTask(@NonNull String taskId);

    void updateTaskStatus(@NonNull String taskId, @NonNull String status);
}
