package com.example.taskplanner.service;

import com.example.taskplanner.model.Sprint;
import com.example.taskplanner.model.Task;
import com.example.taskplanner.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    TaskService taskService;

    @Override
    public String createSprint(@NonNull Sprint sprint) {
        if (sprint.getTaskIdList() == null) {
            sprint.setTaskIdList(new ArrayList<>());
        }
        sprintRepository.createSprint(sprint);
        return sprint.getSprintId();
    }

    @Override
    public Sprint getSprint(@NonNull String sprintId) {
        return sprintRepository.getSprint(sprintId);
    }

    @Override
    public void addTaskToSprint(@NonNull String sprintId, @NonNull String taskId) {
        Task task = taskService.getTask(taskId);
        if (task.getSprintId() != null) {
            removeTaskFromSprint(task.getSprintId(), taskId);
        }
        Sprint sprint = getSprint(sprintId);
        List<String> taskIdList = sprint.getTaskIdList();
        taskIdList.add(taskId);
        sprint.setTaskIdList(taskIdList);
        task.setSprintId(sprintId);
        sprintRepository.updateSprint(sprint);
    }

    @Override
    public void removeTaskFromSprint(@NonNull String sprintId, @NonNull String taskId) {
        Task task = taskService.getTask(taskId);
        Sprint sprint = getSprint(sprintId);
        List<String> taskIdList = sprint.getTaskIdList();
        for (String currTaskId : taskIdList) {
            if (Objects.equals(currTaskId, taskId)) {
                taskIdList.remove(taskId);
            }
        }
        sprint.setTaskIdList(taskIdList);
        task.setSprintId(null);
        sprintRepository.updateSprint(sprint);
    }
}
