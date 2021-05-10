package ru.forum.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import ru.forum.ForumApplication;
import ru.forum.domain.Role;
import ru.forum.repositories.PostRepository;
import ru.forum.repositories.RoleRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ForumApplication.class)
class DefaultRoleServiceTest {

    @Mock
    private RoleRepository roleRepository;
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        roleService = new DefaultRoleService(roleRepository);
    }

    @Test
    void findByName() {
        Role role = Role.builder().id(2).name("USER").build();
        when(roleRepository.findByName(anyString())).thenReturn(role);

        Role returnRole = roleService.findByName("USER");
        assertEquals(returnRole.getName(), "USER");
        assertEquals(returnRole.getId(), 2);
    }
}