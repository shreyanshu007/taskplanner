package com.example.taskplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @NonNull
    String taskId;

    @NonNull
    String title;

    @NonNull
    String creator;

    @Nullable
    String assignee;

    @NonNull
    String status;

    @NonNull
    String type;

    @NonNull
    LocalDateTime dueDate;

    @Nullable
    String sprintId;

}
