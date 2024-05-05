package ru.bazunaka.bazbloglite.Services;

import ru.bazunaka.bazbloglite.Entity.User;

import java.util.Optional;

public interface UserService {
    void createUserAccount(User user);

    Optional<User> findUserByUsername(String username);
}
