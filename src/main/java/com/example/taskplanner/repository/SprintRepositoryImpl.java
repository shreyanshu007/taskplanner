package com.example.taskplanner.repository;

import com.example.taskplanner.model.Sprint;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SprintRepositoryImpl implements SprintRepository{

    private final HashMap<String, Sprint> sprintHashMap = new HashMap<>();

    @Override
    public void createSprint(Sprint sprint) {
        sprintHashMap.put(sprint.getSprintId(), sprint);
    }

    @Override
    public Sprint getSprint(String sprintId) {
        return sprintHashMap.get(sprintId);
    }

    @Override
    public void updateSprint(Sprint sprint) {
        sprintHashMap.put(sprint.getSprintId(), sprint);
    }
}
