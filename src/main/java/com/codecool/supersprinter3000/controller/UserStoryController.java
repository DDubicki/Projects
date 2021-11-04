package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = {"/"})
//@RestController
public class UserStoryController {

    private final UserStoryService service;

    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    @GetMapping()
//    @PostMapping
//    @DeleteMapping
//    @PutMapping
//    @ResponseBody
    public String getIndexPage(Model model) {
        model.addAttribute("title", "Super Sprinter");
        model.addAttribute("allUserStories", service.getAll());
        return "index";
    }

    @ResponseBody
    @GetMapping("/populate")
    public void populate() {
        UserStory userStory = new UserStory();
        userStory.setEstimation(10);
        userStory.setStatus("tytul 1");

        UserStory userStory2 = new UserStory();
        userStory2.setEstimation(5);
        userStory2.setStatus("tytul 2");
        System.out.println("s");
        service.saveAll(Arrays.asList(userStory, userStory2));
    }

    @GetMapping("/story")
    public String getStoryPage(Model model) {
        model.addAttribute("title", "New story");
        return "story";
    }

    @PostMapping("/story")
    public void addStory(@RequestParam("story") List<String> data) {
        System.out.println(data);
    }


}
