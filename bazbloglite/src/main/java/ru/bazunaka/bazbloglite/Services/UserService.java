package ru.bazunaka.bazbloglite.Services;

import org.springframework.security.core.userdetails.UserDetails;
import ru.bazunaka.bazbloglite.Entity.User;

import java.util.Optional;

public interface UserService {
    void createUserAccount(User user);

    Optional<UserDetails> findUserByUsername(String username);
}
