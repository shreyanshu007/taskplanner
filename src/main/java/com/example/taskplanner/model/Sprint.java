package com.example.taskplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@AllArgsConstructor
public class Sprint {

    @NonNull
    String sprintId;

    @Nullable
    String description;

    @NonNull
    String creator;

    @Nullable
    List<String> taskIdList;

}
