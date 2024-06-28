package ru.bazunaka.bazbloglite.Usecase.impl;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Mapper.TweetToTweetResponseMapper;
import ru.bazunaka.bazbloglite.Model.TweetFindRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;
import ru.bazunaka.bazbloglite.Services.CurrentUserProfileService;
import ru.bazunaka.bazbloglite.Services.TweetService;
import ru.bazunaka.bazbloglite.Usecase.TweetFindCase;

import java.util.Collection;

@Component
public class TweetFindCaseFacade implements TweetFindCase {

    private final CurrentUserProfileService currentUserProfileService;
    private final TweetService tweetService;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;

    public TweetFindCaseFacade(CurrentUserProfileService currentUserProfileService,
            TweetService tweetService,
            TweetToTweetResponseMapper tweetToTweetResponseMapper) {
        this.currentUserProfileService = currentUserProfileService;
        this.tweetService = tweetService;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
    }

    @Override
    public Collection<TweetResponse> findTweets(TweetFindRequest findRequest) {
        UserProfile owner = this.currentUserProfileService.currentUserProfile();

        PageRequest pageable = PageRequest.of(findRequest.page(), findRequest.limit());

        Collection<Tweet> allOwnerTweets = this.tweetService.findAllTweets(owner, pageable);

        return allOwnerTweets
                .stream()
                .map(this.tweetToTweetResponseMapper::map)
                .toList();
    }
}
