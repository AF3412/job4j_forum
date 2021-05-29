package ru.af3412.forum.service;

import org.springframework.stereotype.Service;
import ru.af3412.forum.model.User;
import ru.af3412.forum.store.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByName(User user) {
        return userRepository.findByUsername(user.getUsername());
    }

    public User save(User user) {
        return userRepository.save(user);
    }


}
