package ru.bazunaka.bazbloglite.Usecase.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Mapper.TweetAddRequestToTweetMapper;
import ru.bazunaka.bazbloglite.Mapper.TweetToTweetResponseMapper;
import ru.bazunaka.bazbloglite.Model.TweetAddRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;
import ru.bazunaka.bazbloglite.Services.TweetService;
import ru.bazunaka.bazbloglite.Usecase.TweetAddUsecase;

@Component
public class TweetAddUsecaseFacade implements TweetAddUsecase {

    private final TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;

    public TweetAddUsecaseFacade(TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper,
                                 TweetToTweetResponseMapper tweetToTweetResponseMapper,
                                 TweetService tweetService) {
        this.tweetAddRequestToTweetMapper = tweetAddRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.tweetService = tweetService;
    }

    @Override
    public TweetResponse addTweet(TweetAddRequest addRequest) {
        Tweet mappedTweet = this.tweetAddRequestToTweetMapper.map(addRequest);
        Tweet createdTweet = this.tweetService.createTweet(mappedTweet);
        return this.tweetToTweetResponseMapper.map(createdTweet);
    }
}
