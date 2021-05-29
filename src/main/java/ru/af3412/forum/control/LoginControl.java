package ru.af3412.forum.control;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.af3412.forum.model.User;
import ru.af3412.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class LoginControl {

    private final UserService userService;

    public LoginControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,
                               @RequestParam(value = "logout", required = false) boolean logout,
                               Model model) {
        if (error) {
            model.addAttribute("errorMessage", "User not found or incorrect password");
        }
        if (logout) {
            model.addAttribute("errorMessage", "You have been successfully logged out");
        }
        return "login";
    }

    /*@PostMapping("/login")
    public String userLogin(@ModelAttribute User user) {
        Optional<User> exist = userService.findByName(user);
        if (exist.isPresent() && exist.get().getPassword().equals(user.getPassword())) {
            return "redirect:/index";
        }
        return "redirect:/login?error=true";
    }*/

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }
}
