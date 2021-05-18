package ru.forum.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import ru.forum.ForumApplication;
import ru.forum.domain.Post;
import ru.forum.repositories.PostRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ForumApplication.class)
class DefaultPostServiceTest {

    @Mock
    private PostRepository postRepository;
    private PostService postService;

    @BeforeEach
    void setUp() {
        postService = new DefaultPostService(postRepository);
    }

    @Test
    void findById() {
        Post post = Post.builder().id(3).name("Тема").description("Описание").build();
        Optional<Post> postOptional = Optional.of(post);
        when(postRepository.findById(anyInt())).thenReturn(postOptional);
        Post returnPost = postService.findById(3);
        assertEquals(returnPost.getId(), 3);
        assertEquals(returnPost.getName(), "Тема");
        assertEquals(returnPost.getDescription(), "Описание");
    }

    @Test
    void findAll() {
        List<Post> posts = List.of(
                Post.builder().id(3).name("Тема3").description("Описание3").build(),
                Post.builder().id(5).name("Тема5").description("Описание5").build(),
                Post.builder().id(7).name("Тема7").description("Описание7").build()
        );
        when(postService.findAll()).thenReturn(posts);
        List<Post> returnPosts = postService.findAll();
        assertEquals(returnPosts.size(),3);
    }

    @Test
    void save() {
        Post post = Post.builder().id(3).name("Тема").description("Описание").build();
        postService.save(post);

        verify(postRepository,times(1)).save(post);
    }
}