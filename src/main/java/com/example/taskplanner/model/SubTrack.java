package com.example.taskplanner.model;

import com.example.taskplanner.constant.SubTrackStatus;
import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
public class SubTrack {

    @NonNull
    String subTrackId;

    @NonNull
    String title;

    @Nullable
    String summary;

    @NonNull
    String status;

    public SubTrack(@NonNull String subTrackId, @NonNull String title, @Nullable String summary) {
        this.subTrackId = subTrackId;
        this.title = title;
        this.summary = summary;
        this.status = SubTrackStatus.OPEN.name();
    }
}
