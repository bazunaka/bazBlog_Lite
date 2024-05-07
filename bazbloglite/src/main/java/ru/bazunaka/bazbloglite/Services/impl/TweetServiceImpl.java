package ru.bazunaka.bazbloglite.Services.impl;

import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Repository.TweetRepository;
import ru.bazunaka.bazbloglite.Services.TweetService;

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
}
