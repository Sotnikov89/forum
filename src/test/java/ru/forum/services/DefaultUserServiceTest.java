package ru.forum.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import ru.forum.ForumApplication;
import ru.forum.domain.Post;
import ru.forum.domain.Role;
import ru.forum.domain.User;
import ru.forum.repositories.RoleRepository;
import ru.forum.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ForumApplication.class)
class DefaultUserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new DefaultUserService(userRepository);
    }

    @Test
    void save() {
        User user = User.builder().id(3).username("Имя").build();
        userService.save(user);

        verify(userRepository,times(1)).save(user);
    }
}