package ru.forum.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.forum.domain.Post;
import ru.forum.services.DefaultPostService;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
public class PostController {

    private final DefaultPostService postService;

    @GetMapping("/{id}")
    public String getPostPage(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "postDesc";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("post", Post.builder().created(LocalDateTime.now()).build());
        return "postEdit";
    }

    @GetMapping("/update/{id}")
    public String getEditForm(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "postEdit";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute Post post) {
        if (post.getCreated() == null) {
            post.setCreated(LocalDateTime.now());
        }
        postService.save(post);
        return "redirect:/index";
    }
}
