package com.example.taskplanner.service;

import com.example.taskplanner.model.Sprint;
import org.springframework.lang.NonNull;

public interface SprintService {

    /**
     * To create a new sprint
     *
     * @param sprint
     * @return sprintId
     */
    String createSprint(@NonNull Sprint sprint);

    Sprint getSprint(@NonNull String sprintId);

    void addTaskToSprint(@NonNull String sprintId, @NonNull String taskId);

    void removeTaskFromSprint(@NonNull String sprintId, @NonNull String taskId);
}
