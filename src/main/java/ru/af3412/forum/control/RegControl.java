package ru.af3412.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.af3412.forum.model.User;
import ru.af3412.forum.store.MemStore;

@Controller
public class RegControl {


    private final MemStore store;

    public RegControl(MemStore store) {
        this.store = store;
    }

    @GetMapping({"/reg"})
    public String viewRegPage() {
        return "reg";
    }

    @PostMapping({"/reg"})
    public String regUser(@ModelAttribute User user) {
        store.addUser(user);
        return "redirect:/login";
    }

}
