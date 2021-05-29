package ru.af3412.forum.control;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.af3412.forum.model.Post;
import ru.af3412.forum.model.User;
import ru.af3412.forum.service.PostService;
import ru.af3412.forum.service.UserService;

import java.util.Calendar;

@Controller
public class PostControl {

    private final PostService postService;
    private final UserService userService;

    public PostControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/posts/create")
    public String createPost(Model model) {
        return "edit";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.getById(id));
        return "edit";
    }

    @PostMapping("/posts/save")
    public String save(@ModelAttribute Post post, Authentication authentication) {
        String currentPrincipalName = authentication.getName();
        User user = userService.findByName(currentPrincipalName).get();
        post.setUser(user);
        post.setCreated(Calendar.getInstance());
        post.setDescription(post.getName());
        postService.save(post);
        return "redirect:/index";
    }

}
