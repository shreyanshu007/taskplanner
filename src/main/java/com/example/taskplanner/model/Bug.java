package com.example.taskplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Bug extends Task {

    @Nullable
    String summary;

    @NonNull
    String severity;
}
