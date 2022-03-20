package com.example.taskplanner.repository;

import com.example.taskplanner.model.Task;
import org.springframework.lang.NonNull;

public interface TaskRepository {

    void createTask(@NonNull Task task);

    Task getTask(@NonNull String taskId);

    void updateTask(@NonNull Task task);
}
