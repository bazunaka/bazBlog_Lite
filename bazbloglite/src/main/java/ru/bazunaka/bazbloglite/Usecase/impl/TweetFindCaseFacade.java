package ru.bazunaka.bazbloglite.Usecase.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Mapper.TweetPageToTweetPageResponseMapper;
import ru.bazunaka.bazbloglite.Model.TweetFindRequest;
import ru.bazunaka.bazbloglite.Model.TweetPageResponse;
import ru.bazunaka.bazbloglite.Services.CurrentUserProfileService;
import ru.bazunaka.bazbloglite.Services.TweetService;
import ru.bazunaka.bazbloglite.Usecase.TweetFindCase;

import static ru.bazunaka.bazbloglite.Entity.Tweet_.CREATED_TIME;

@Component
public class TweetFindCaseFacade implements TweetFindCase {

    private final CurrentUserProfileService currentUserProfileService;
    private final TweetService tweetService;
    private final TweetPageToTweetPageResponseMapper tweetPageToTweetPageResponseMapper;

    public TweetFindCaseFacade(CurrentUserProfileService currentUserProfileService,
            TweetService tweetService,
            TweetPageToTweetPageResponseMapper tweetPageToTweetPageResponseMapper) {
        this.currentUserProfileService = currentUserProfileService;
        this.tweetService = tweetService;
        this.tweetPageToTweetPageResponseMapper = tweetPageToTweetPageResponseMapper;
    }

    @Override
    public TweetPageResponse findTweets(TweetFindRequest findRequest) {
        UserProfile owner = this.currentUserProfileService.currentUserProfile();

        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_TIME);

        PageRequest pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);

        Page<Tweet> pageableTweetResult = this.tweetService.findAllTweets(owner, pageable);

        return this.tweetPageToTweetPageResponseMapper.map(pageableTweetResult);
    }
}
