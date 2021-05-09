package ru.forum.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.forum.ForumApplication;
import ru.forum.domain.Post;
import ru.forum.services.PostService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ForumApplication.class)
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private PostService postService;

    private PostController postController;

    @BeforeEach
    void setUp() {
        postController = new PostController(postService);
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @Test
    @WithMockUser
    void getPostPage() throws Exception {
        Post post = Post.builder().id(6).build();
        when(postService.findById(anyInt())).thenReturn(post);

        this.mockMvc.perform(get("/6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"))
                .andExpect(view().name("postDesc"));

        verify(postService, times(1)).findById(anyInt());
    }

    @Test
    @WithMockUser
    void getCreateForm() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"))
                .andExpect(view().name("postEdit"));
    }

    @Test
    @WithMockUser
    void getEditForm() throws Exception {
        Post post = Post.builder().id(5).build();
        when(postService.findById(anyInt())).thenReturn(post);

        this.mockMvc.perform(get("/update/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"))
                .andExpect(view().name("postEdit"));

        verify(postService, times(1)).findById(anyInt());
    }

    @Test
    @WithMockUser
    void saveOrUpdate() throws Exception {
        this.mockMvc.perform(post("/saveOrUpdate")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name","Название поста")
                .param("desc", "Описание поста"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/index"));
        verify(postService, times(1)).save(any());

        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).save(argument.capture());
        assertThat(argument.getValue().getName(), is("Название поста"));
        assertThat(argument.getValue().getDesc(), is("Описание поста"));
    }
}