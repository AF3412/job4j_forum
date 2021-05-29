package ru.af3412.forum.service;


import org.springframework.stereotype.Service;
import ru.af3412.forum.model.Post;
import ru.af3412.forum.store.MemStore;

import java.util.List;

@Service
public class PostService {

    private final MemStore memStore;

    public PostService(MemStore memStore) {
        this.memStore = memStore;
    }

    public List<Post> getAll() {
        return memStore.getAllPosts();
    }

    public Post getById(int id) {
        return memStore.getPostById(id);
    }

    public void save(Post post) {
        memStore.addPost(post);
    }
}
