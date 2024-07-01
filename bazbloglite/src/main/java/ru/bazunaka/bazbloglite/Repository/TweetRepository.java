package ru.bazunaka.bazbloglite.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Entity.UserProfile;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Page<Tweet> findAllByUserProfile(UserProfile userProfile, PageRequest pageable);
}
