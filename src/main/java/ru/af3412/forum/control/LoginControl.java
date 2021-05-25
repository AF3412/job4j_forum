package ru.af3412.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.af3412.forum.model.User;
import ru.af3412.forum.store.MemStore;

import java.util.Optional;

@Controller
public class LoginControl {

    private final MemStore store;

    public LoginControl(MemStore store) {
        this.store = store;
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,
                               Model model) {
        if (error) {
            model.addAttribute("errorMessage", "User not found or incorrect password");
        }
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(@ModelAttribute User user) {
        Optional<User> exist = store.findUserByName(user.getUsername());
        if (exist.isPresent() && exist.get().getPassword().equals(user.getPassword())) {
            return "redirect:/index";
        }
        return "redirect:/login?error=true";
    }
}
