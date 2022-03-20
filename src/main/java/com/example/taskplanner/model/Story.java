package com.example.taskplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Story extends Task {

    @Nullable
    String summary;

    @Nullable
    List<SubTrack> subTracks;
}
