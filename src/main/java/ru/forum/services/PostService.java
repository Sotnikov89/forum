package ru.forum.services;

import ru.forum.domain.Post;

import java.util.List;

public interface PostService {
    Post findById(int id);
    List<Post> findAll();
    boolean save(Post post);
}
