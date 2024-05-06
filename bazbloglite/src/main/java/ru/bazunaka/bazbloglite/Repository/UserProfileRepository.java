package ru.bazunaka.bazbloglite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazunaka.bazbloglite.Entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
