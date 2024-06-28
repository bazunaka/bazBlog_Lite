package ru.bazunaka.bazbloglite.Usecase.impl;

import ru.bazunaka.bazbloglite.Model.TweetResponse;
import ru.bazunaka.bazbloglite.Services.CurrentUserProfileService;
import ru.bazunaka.bazbloglite.Services.TweetService;
import ru.bazunaka.bazbloglite.Usecase.TweetFindCase;

import java.util.Collection;

public class TweetFindCaseFacade implements TweetFindCase {

    private final CurrentUserProfileService currentUserProfileService;
    private final TweetService tweetService;

    public TweetFindCaseFacade(CurrentUserProfileService currentUserProfileService, TweetService tweetService) {
        this.currentUserProfileService = currentUserProfileService;
        this.tweetService = tweetService;
    }

    @Override
    public Collection<TweetResponse> findTweets() {
        return null;
    }
}
