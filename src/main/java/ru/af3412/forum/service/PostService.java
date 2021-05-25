package ru.af3412.forum.service;


import org.springframework.stereotype.Service;
import ru.af3412.forum.model.Post;
import ru.af3412.forum.store.MemStore;

import java.util.List;

@Service
public class PostService {

    private final MemStore store = MemStore.instOf();

    public List<Post> getAll() {
        return store.getAllPosts();
    }

    public Post getById(int id) {
        return store.getPostById(id);
    }

    public void save(Post post) {
        store.addPost(post);
    }
}
