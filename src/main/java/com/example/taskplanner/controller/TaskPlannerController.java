package com.example.taskplanner.controller;

import com.example.taskplanner.model.Sprint;
import com.example.taskplanner.model.SubTrack;
import com.example.taskplanner.model.Task;
import com.example.taskplanner.service.SprintService;
import com.example.taskplanner.service.SubTrackService;
import com.example.taskplanner.service.TaskService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "TaskPlannerController")
@RequestMapping("/planner")
public class TaskPlannerController {

    @Autowired
    SprintService sprintService;

    @Autowired
    SubTrackService subTrackService;

    @Autowired
    TaskService taskService;

    @GetMapping("sprint")
    public Sprint getSprint(
            @NonNull @RequestHeader String sprintId) {
        return sprintService.getSprint(sprintId);
    }

    @PostMapping("sprint")
    public String createSprint(
            @NonNull @RequestBody Sprint sprint) {
        return sprintService.createSprint(sprint);
    }

    @PutMapping("sprint/task")
    public String addTaskToSprint(
            @NonNull @RequestHeader String sprintId,
            @NonNull @RequestHeader String taskId) {
        sprintService.addTaskToSprint(sprintId, taskId);
        return "Task added to the Sprint";
    }

    @DeleteMapping("sprint/task")
    public String removeTaskFromSprint(
            @NonNull @RequestHeader String sprintId,
            @NonNull @RequestHeader String taskId) {
        sprintService.removeTaskFromSprint(sprintId, taskId);
        return "Task removed from the Sprint";
    }

    @GetMapping("task")
    public Task getTask(
            @NonNull @RequestHeader String taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping("task")
    public String createTask(
            @NonNull @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("task")
    public String updateStatus(
            @NonNull @RequestHeader String taskId,
            @NonNull @RequestHeader String status) {
        taskService.updateTaskStatus(taskId, status);
        return "Status of Task updated";
    }

    @PostMapping("task/subtrack")
    public String addSubTrack(
            @NonNull @RequestHeader String taskId,
            @NonNull @RequestBody SubTrack subTrack) {
        return subTrackService.createSubTrack(taskId, subTrack);
    }

    @PutMapping("task/subtrack")
    public String updateSubTrack(
            @NonNull @RequestHeader String taskId,
            @NonNull @RequestHeader String subTrackId,
            @NonNull @RequestHeader String status) {
        subTrackService.updateSubTrackStatus(taskId, subTrackId, status);
        return "Status of SubTrack updated";
    }
}
