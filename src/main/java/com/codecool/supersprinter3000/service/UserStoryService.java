package com.codecool.supersprinter3000.service;


import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        story.setStatus("planning");
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
        story.setStatus("planning");
    }

    public Optional<UserStory> getStoryById(Long storyId) {
        return repository.findById(storyId);
    }

    @Transactional // thanks this we shouldn't use query in Repository
    public void updateStory(Long storyId, UserStory newStory) {
        UserStory userStory = repository.findById(storyId)
                .orElseThrow(()-> new IllegalStateException("Story with id" + storyId + " doesn't exist!"));
        userStory.setTitle(newStory.getTitle());
        userStory.setDescription(newStory.getDescription());
        userStory.setAcceptanceCriteria(newStory.getAcceptanceCriteria());
        userStory.setBusinessValue(newStory.getBusinessValue());
        userStory.setEstimation(newStory.getEstimation());
        userStory.setStatus(newStory.getStatus());
    }

    // TODO: fix this method. ID of updating story is changed because of @GeneratedValue
    public void updateStory2(Long storyId, UserStory newStory) {
        UserStory storyBeforeUpdate = repository.findById(storyId)
                .orElseThrow(() -> new IllegalStateException("Story with id" + storyId + " doesn't exist!"));
//        newStory.setId(storyId);
        newStory.setStatus(storyBeforeUpdate.getStatus());
        repository.delete(storyBeforeUpdate);
        repository.save(newStory);
    }
}

