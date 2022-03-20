package com.example.taskplanner.service;

import com.example.taskplanner.model.SubTrack;
import org.springframework.lang.NonNull;

public interface SubTrackService {

    /**
     * To create new Sub Track
     *
     * @param taskId
     * @param subTrack
     * @returnsubTrackId
     */
    String createSubTrack(@NonNull String taskId, @NonNull SubTrack subTrack);

    void updateSubTrackStatus(@NonNull String taskId, @NonNull String subTrackId, @NonNull String status);
}
