package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = {"/"})
//@RestController
public class UserStoryController {

    private final UserStoryService service;

    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    @GetMapping()
//    @DeleteMapping
//    @ResponseBody
    public String getIndexPage(Model model) {
        model.addAttribute("title", "Super Sprinter");
        model.addAttribute("allUserStories", service.getAll());
        return "index";
    }

    @GetMapping("/story")
    public String getStoryPage(Model model) {
        model.addAttribute("title", "New story");
        return "/story/add_story";
    }

    @ResponseBody // return response (object) from server to JS
    @PostMapping(value = "/story")
    public UserStory addStory(@RequestBody UserStory story) {
        service.saveNewStory(story);
        return story;
    }

//    @PostMapping("/story")
//    public void addStory2(@RequestParam HashMap<String, String> parameters) {
//        service.saveNewStory2(parameters);
//    }

    @GetMapping("/story/{storyId}")
    public String getUpdateStory(@PathVariable("storyId") Long storyId, Model model) {
        Optional<UserStory> optional = service.getStoryById(storyId);
        if (optional.isPresent()) {
            model.addAttribute("storyId", storyId);
            model.addAttribute("title", "Update story");
            model.addAttribute("current_story", optional.get());
        } else {
            throw new IllegalStateException("There are no story with id " + storyId);
        }
        return "story/update_story";
    }

    @PutMapping("/story/{storyId}")
    public String updateStory(@PathVariable("storyId") Long storyId,
                              @RequestBody UserStory userStory) {
        service.updateStory(storyId, userStory);
//        service.updateStory2(storyId, userStory);
        return "redirect:/";
    }
}
