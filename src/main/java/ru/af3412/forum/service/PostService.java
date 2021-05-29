package ru.af3412.forum.service;


import org.springframework.stereotype.Service;
import ru.af3412.forum.model.Post;
import ru.af3412.forum.store.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        this.postRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post getById(int id) {
        final Optional<Post> optionalPost = this.postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new IllegalArgumentException("Post with id %d not found!".formatted(id));
        }
        return optionalPost.get();
    }

    public Post save(Post post) {
        return this.postRepository.save(post);
    }

}
