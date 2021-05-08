package ru.forum.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.forum.domain.User;
import ru.forum.repositories.UserRepository;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean save(User user) {
        boolean rsl = false;
        try {
            userRepository.save(user);
            rsl = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        userRepository.findAll().forEach(System.out::println);
        return rsl;
    }
}
