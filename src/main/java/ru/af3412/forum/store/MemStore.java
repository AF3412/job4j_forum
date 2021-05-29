package ru.af3412.forum.store;

import org.springframework.stereotype.Repository;
import ru.af3412.forum.model.Post;
import ru.af3412.forum.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemStore {

    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final AtomicInteger userCount = new AtomicInteger(0);
    private final AtomicInteger postCount = new AtomicInteger(0);

    private MemStore() {
        users.put(userCount.get(), new User(userCount.get(), "root", "password"));
        users.put(userCount.incrementAndGet(), new User(userCount.get(), "user", "password"));
        posts.put(postCount.get(), Post.of("Правила форума"));
        posts.put(postCount.incrementAndGet(), Post.of("Продам авто"));
    }

    public Optional<User> findUserByName(String name) {
        return users.values().stream()
                .filter(v -> v.getUsername().equals(name))
                .findFirst();
    }

    public User addUser(User user) {
        int id = userCount.incrementAndGet();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public List<Post> getAllPosts() {
        List<Post> result = new ArrayList<>();
        posts.forEach(
                (k, v) -> result.add(Post.of(k, v.getName(), v.getDesc(), v.getCreated()))
        );
        return result;
    }

    public Post addPost(Post post) {
        post.setId(postCount.incrementAndGet());
        posts.put(post.getId(), post);
        return post;
    }

    public Post getPostById(int id) {
        return posts.get(id);
    }
}
