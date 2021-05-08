package ru.forum.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.forum.services.DefaultPostService;

@Controller
@AllArgsConstructor
public class IndexController {

    private final DefaultPostService postService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }
}
