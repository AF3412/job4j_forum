package ru.af3412.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.af3412.forum.config.SessionUserConfig;
import ru.af3412.forum.model.Post;
import ru.af3412.forum.model.User;
import ru.af3412.forum.service.PostService;

@Controller
public class PostControl {

    private final PostService postService;
    private final SessionUserConfig sessionUserConfig;

    public PostControl(PostService postService, SessionUserConfig sessionUserConfig) {
        this.postService = postService;
        this.sessionUserConfig = sessionUserConfig;
    }

    @GetMapping("/posts/create")
    public String createPost(Model model) {
        Post post = new Post();
        post.setId(-1);
        model.addAttribute("post", post);
        return "edit";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.getById(id));
        return "edit";
    }

    @PostMapping("/posts/save")
    public String save(@ModelAttribute Post post) {
        User user = sessionUserConfig.getUser();
        user.getPosts().add(post);
        postService.save(post);
        return "redirect:/index";
    }

}
