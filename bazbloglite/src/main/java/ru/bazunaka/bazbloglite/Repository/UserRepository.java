package ru.bazunaka.bazbloglite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazunaka.bazbloglite.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
}
