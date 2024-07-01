package ru.bazunaka.bazbloglite.Services;

import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Entity.UserProfile;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface TweetService {
    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Optional<Tweet> findTweetById(long tweetId);

    void deleteTweet(long tweetId);

    Page<Tweet> findAllTweets(UserProfile owner, PageRequest pageable);
}
