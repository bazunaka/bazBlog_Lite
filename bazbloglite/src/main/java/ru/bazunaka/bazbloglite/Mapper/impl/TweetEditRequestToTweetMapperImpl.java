package ru.bazunaka.bazbloglite.Mapper.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Mapper.TweetEditRequestToTweetMapper;
import ru.bazunaka.bazbloglite.Model.TweetEditRequest;
import ru.bazunaka.bazbloglite.Services.TweetService;

@Component
public class TweetEditRequestToTweetMapperImpl implements TweetEditRequestToTweetMapper {

    private final TweetService tweetService;

    public TweetEditRequestToTweetMapperImpl(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Override
    public Tweet map(TweetEditRequest request) {
        Tweet currentTweet = this.tweetService
                .findTweetById(request.id())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Пост с id = %d не существует", request.id());
                    return new RuntimeException(errorMessage);
                });

        currentTweet.setMessage(request.message());

        return currentTweet;
    }
}
