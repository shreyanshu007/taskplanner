package com.example.taskplanner.repository;

import com.example.taskplanner.model.Bug;
import com.example.taskplanner.model.Task;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final HashMap<String, Task> taskHashMap = new HashMap<>();

    @Override
    public void createTask(@NonNull Task task) {
        taskHashMap.put(task.getTaskId(), task);
    }

    @Override
    public Task getTask(@NonNull String taskId) {
        return taskHashMap.get(taskId);
    }

    @Override
    public void updateTask(@NonNull Task task) {
        taskHashMap.put(task.getTaskId(), task);
    }
}
