package ru.bazunaka.bazbloglite.Usecase.impl;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Mapper.TweetToTweetResponseMapper;
import ru.bazunaka.bazbloglite.Model.TweetFindRequest;
import ru.bazunaka.bazbloglite.Model.TweetPageResponse;
import ru.bazunaka.bazbloglite.Model.TweetResponse;
import ru.bazunaka.bazbloglite.Services.CurrentUserProfileService;
import ru.bazunaka.bazbloglite.Services.TweetService;
import ru.bazunaka.bazbloglite.Usecase.TweetFindCase;

import java.util.Collection;

import static ru.bazunaka.bazbloglite.Entity.Tweet_.CREATED_TIME;

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
    public TweetPageResponse findTweets(TweetFindRequest findRequest) {
        UserProfile owner = this.currentUserProfileService.currentUserProfile();

        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_TIME);

        PageRequest pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);

        Collection<Tweet> allOwnerTweets = this.tweetService.findAllTweets(owner, pageable);

        Collection<TweetResponse> tweetResponses = allOwnerTweets
                .stream()
                .map(this.tweetToTweetResponseMapper::map)
                .toList();

        return new TweetPageResponse(tweetResponses);
    }
}
