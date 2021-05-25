package ru.af3412.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.af3412.forum.store.MemStore;

@Controller
public class IndexControl {
    private final MemStore store = MemStore.instOf();

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", store.getAllPosts());
        return "index";
    }
}
