package com.codecool.supersprinter3000.service;


import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserStoryService {
    private final UserStoryRepository repository;

    @Autowired
    public UserStoryService(UserStoryRepository repository) {
        this.repository = repository;
    }

    public Iterable<UserStory> getAll() {
        return repository.findAll();
    }

    public void saveAll(List<UserStory> userStories) {
        repository.saveAll(userStories);
    }

    public void saveNewStory(UserStory story) {
        story.setStatus("New");
        repository.save(story);
    }

    public void saveNewStory2(HashMap<String, String> parameters) {
        UserStory story = new UserStory();
        populateStory(parameters, story);
        repository.save(story);
    }

    private void populateStory(HashMap<String, String> parameters, UserStory story) {
        story.setTitle(parameters.get("title"));
        story.setDescription(parameters.get("description"));
        story.setAcceptanceCriteria(parameters.get("acceptanceCriteria"));
        story.setBusinessValue(Integer.parseInt(parameters.get("businessValue")));
        story.setEstimation(Double.parseDouble(parameters.get("estimation")));
        story.setStatus("New");
    }

    public Optional<UserStory> getStoryById(Long storyId) {
        return repository.findById(storyId);
    }

    public void updateStory(Long storyId, UserStory newStory) {
        Optional<UserStory> storyBeforeUpdate = repository.findById(storyId);
        if (storyBeforeUpdate.isPresent()){
            newStory.setId(storyId);
            newStory.setStatus(storyBeforeUpdate.get().getStatus());
            repository.delete(storyBeforeUpdate.get());
        }
        repository.save(newStory);
    }
}
