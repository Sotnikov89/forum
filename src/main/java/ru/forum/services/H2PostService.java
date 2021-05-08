package ru.forum.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.forum.domain.Post;
import ru.forum.repositories.PostRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class H2PostService implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post findById(int id) {
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with this id not found"));
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public boolean save(Post post) {
        boolean rsl = false;
        try {
            postRepository.save(post);
            rsl = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
