package ru.forum.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.forum.domain.User;
import ru.forum.services.DefaultAuthorityService;
import ru.forum.services.DefaultUserService;

@Controller
@AllArgsConstructor
public class RegControl {

    //private final PasswordEncoder encoder;
    private final DefaultUserService userService;
    private final DefaultAuthorityService authorityService;

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        user.setEnabled(true);
        //user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityService.findByAuthority("ROLE_USER"));
        boolean rsl = userService.save(user);
        if (rsl) {
            model.addAttribute("errorMessage", "Username is exist !!");
        }
        return rsl ? "redirect:/login" : "/reg";
    }
}
