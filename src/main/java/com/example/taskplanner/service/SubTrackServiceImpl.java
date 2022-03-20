package com.example.taskplanner.service;

import com.example.taskplanner.model.Story;
import com.example.taskplanner.model.SubTrack;
import com.example.taskplanner.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTrackServiceImpl implements SubTrackService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public String createSubTrack(@NonNull String taskId, @NonNull SubTrack subTrack) {
        Story story = (Story) taskRepository.getTask(taskId);
        List<SubTrack> subTrackList = story.getSubTracks();
        subTrackList.add(subTrack);
        story.setSubTracks(subTrackList);
        taskRepository.updateTask(story);
        return null;
    }

    @Override
    public void updateSubTrackStatus(@NonNull String taskId, @NonNull String subTrackId, @NonNull String status) {
        Story story = (Story) taskRepository.getTask(taskId);
        List<SubTrack> subTrackList = story.getSubTracks();
        for (SubTrack subTrack : subTrackList) {
            if (subTrack.getSubTrackId().equals(subTrackId)) {
                subTrack.setStatus(status);
            }
        }
    }
}
