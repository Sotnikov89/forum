package ru.forum.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.forum.domain.Role;
import ru.forum.repositories.RoleRepository;

@Service
@AllArgsConstructor
public class DefaultRoleService implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
