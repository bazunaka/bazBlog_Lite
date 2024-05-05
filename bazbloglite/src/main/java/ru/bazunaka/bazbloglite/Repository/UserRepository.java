package ru.bazunaka.bazbloglite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.bazunaka.bazbloglite.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

   Optional<UserDetails> findByUsername(String username);
}
