package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.model.UserStory;
import com.codecool.supersprinter3000.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Controller //
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

    @GetMapping("/story")
    public String getStoryPage(Model model) {
        model.addAttribute("title", "New story");
        return "story";
    }

//    @PostMapping("/story")
    public String addStory(@RequestBody UserStory story) { // Can remove @RequestBody. And it works, but send two forms. One of them is empty
        service.saveNewStory(story);
        return "redirect:/";
//        return "story";
    }

    // TODO - At first send empty form, second send correct form
//    @PostMapping("/story")
//    public String addStory2(@RequestParam HashMap<String, String> parameters) {
//        if (!parameters.isEmpty())
//            service.saveNewStory2(parameters);
//        return "redirect:/";
//    }
}
