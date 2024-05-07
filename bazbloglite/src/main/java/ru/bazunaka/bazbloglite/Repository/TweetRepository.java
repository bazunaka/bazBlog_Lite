package ru.bazunaka.bazbloglite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bazunaka.bazbloglite.Entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
