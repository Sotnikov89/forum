package ru.forum.services;

import ru.forum.domain.Authority;

public interface AuthorityService {
    Authority findByAuthority(String authority);
}
