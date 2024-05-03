package ru.bazunaka.bazbloglite.Services.impl;

import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Entity.User;
import ru.bazunaka.bazbloglite.Repository.UserRepository;
import ru.bazunaka.bazbloglite.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUserAccount(User user) {
        boolean isUsernameExists = this.userRepository.existsByUsername(user.getUsername());

        if (isUsernameExists) {
            throw new RuntimeException("Account already exists");
        }
        this.userRepository.save(user);
    }
}
