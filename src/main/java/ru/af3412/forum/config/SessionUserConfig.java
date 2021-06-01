package ru.af3412.forum.config;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.af3412.forum.model.User;

@Component
@SessionScope
public class SessionUserConfig {

    private final User user = new User();

    public User getUser() {
        return user;
    }

}
