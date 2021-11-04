package com.codecool.supersprinter3000.service;


import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {
    private final UserStoryRepository repository;

    @Autowired
    public UserStoryService(UserStoryRepository repository) {
        this.repository = repository;
    }

    public Iterable<UserStory> getAll(){
        return repository.findAll();
    }

    public void saveAll(List<UserStory> userStories) {
        repository.saveAll(userStories);
    }

    public void saveStory(UserStory story) {
        repository.save(story);
    }
}
