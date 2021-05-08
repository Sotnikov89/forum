package ru.forum.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.forum.domain.Authority;
import ru.forum.repositories.AuthorityRepository;

@Service
@AllArgsConstructor
public class H2AuthorityService implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Override
    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }
}
