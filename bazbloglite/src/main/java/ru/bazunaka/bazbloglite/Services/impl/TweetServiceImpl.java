package ru.bazunaka.bazbloglite.Services.impl;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Repository.TweetRepository;
import ru.bazunaka.bazbloglite.Services.TweetService;

import java.util.Collection;
import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return this.tweetRepository.save(tweet);
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {
        return this.tweetRepository.save(tweet);
    }

    @Override
    public Optional<Tweet> findTweetById(long tweetId) {
        return this.tweetRepository.findById(tweetId);
    }

    @Override
    public void deleteTweet(long tweetId) {
        this.tweetRepository.deleteById(tweetId);
    }

    @Override
    public Page<Tweet> findAllTweets(UserProfile owner, PageRequest pageable) {
        return this.tweetRepository.findAllByUserProfile(owner, pageable);
    }
}
