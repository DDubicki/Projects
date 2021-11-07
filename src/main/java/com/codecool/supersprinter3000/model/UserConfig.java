package com.codecool.supersprinter3000.model;

import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserStoryRepository repository) {
        return args -> {
            UserStory story1 = new UserStory();
            populateStory(story1, "Story title 1", "Bla-bla-bla", "Story ready", 10,
                    15.3, "Old");

            UserStory story2 = new UserStory();
            populateStory(story2, "Story title 2", "Story description", "Story not ready", 5,
                    20.8, "Old");

            repository.saveAll(List.of(story1, story2));
        };
    }

    private void populateStory(UserStory story, String title, String description, String criteria, int value,
                               double estimation, String status) {
        story.setTitle(title);
        story.setDescription(description);
        story.setAcceptanceCriteria(criteria);
        story.setBusinessValue(value);
        story.setEstimation(estimation);
        story.setStatus(status);
    }
}
