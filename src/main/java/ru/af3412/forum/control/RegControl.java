package ru.af3412.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.af3412.forum.model.User;
import ru.af3412.forum.service.UserService;

@Controller
public class RegControl {

    private final UserService userService;

    public RegControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/reg"})
    public String viewRegPage() {
        return "reg";
    }

    @PostMapping({"/reg"})
    public String regUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }

}
