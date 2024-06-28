package ru.bazunaka.bazbloglite.Services;

import ru.bazunaka.bazbloglite.Entity.Tweet;

import java.util.Optional;

public interface TweetService {
    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Optional<Tweet> findTweetById(long tweetId);

    void deleteTweet(long tweetId);
}
