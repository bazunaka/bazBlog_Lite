package ru.bazblog.bazdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazblog.bazdiary.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
