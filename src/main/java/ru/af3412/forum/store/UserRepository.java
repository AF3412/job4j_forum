package ru.af3412.forum.store;

import org.springframework.data.repository.CrudRepository;
import ru.af3412.forum.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String name);
}
