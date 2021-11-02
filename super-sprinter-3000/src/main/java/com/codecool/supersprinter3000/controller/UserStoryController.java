package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping(value = {"/user", "/"})
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
    public String getIndexPage(Model model){
        model.addAttribute("title", "Welcome Super");
        model.addAttribute("allUserStories", service.getAll());
        return "Index";
    }

    @ResponseBody
    @GetMapping("populate")
    public void populate(){
        UserStory userStory = new UserStory();
        userStory.setEstimation(10);
        userStory.setStatus("tytul 1");

        UserStory userStory2 = new UserStory();
        userStory2.setEstimation(5);
        userStory2.setStatus("tytul 2");

        service.saveAll(Arrays.asList(userStory, userStory2));
    }
}
