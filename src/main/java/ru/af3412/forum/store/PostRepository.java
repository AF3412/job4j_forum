package ru.af3412.forum.store;

import org.springframework.data.repository.CrudRepository;
import ru.af3412.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
