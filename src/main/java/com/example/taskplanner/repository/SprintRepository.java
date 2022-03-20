package com.example.taskplanner.repository;

import com.example.taskplanner.model.Sprint;
import org.springframework.lang.NonNull;

public interface SprintRepository {

    void createSprint(@NonNull Sprint sprint);

    Sprint getSprint(@NonNull String sprintId);

    void updateSprint(@NonNull Sprint sprint);
}
