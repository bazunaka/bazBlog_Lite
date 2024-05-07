package ru.bazunaka.bazbloglite.Mapper.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Mapper.TweetAddRequestToTweetMapper;
import ru.bazunaka.bazbloglite.Model.TweetAddRequest;
import ru.bazunaka.bazbloglite.Services.CurrentUserProfileService;

@Component
public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {

    private final CurrentUserProfileService currentUserProfileService;

    public TweetAddRequestToTweetMapperImpl(CurrentUserProfileService currentUserProfileService) {
        this.currentUserProfileService = currentUserProfileService;
    }

    @Override
    public Tweet map(TweetAddRequest addRequest) {

        Tweet tweet = new Tweet();
        tweet.setUserProfile(this.currentUserProfileService.currentUserProfile());
        tweet.setMessage(addRequest.message());

        return tweet;
    }
}
