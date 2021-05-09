package ru.forum.services;

import ru.forum.domain.Role;

public interface RoleService {
    Role findByName(String name);
}
