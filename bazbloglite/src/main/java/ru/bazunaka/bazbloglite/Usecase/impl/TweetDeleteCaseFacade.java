package ru.bazunaka.bazbloglite.Usecase.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Mapper.TweetEditRequestToTweetMapper;
import ru.bazunaka.bazbloglite.Mapper.TweetToTweetResponseMapper;
import ru.bazunaka.bazbloglite.Services.CurrentUserProfileService;
import ru.bazunaka.bazbloglite.Services.TweetService;
import ru.bazunaka.bazbloglite.Usecase.TweetDeleteCase;

@Component
public class TweetDeleteCaseFacade implements TweetDeleteCase {

    private final TweetService tweetService;
    private final CurrentUserProfileService currentUserProfileService;

    public TweetDeleteCaseFacade(TweetService tweetService, CurrentUserProfileService currentUserProfileService) {
        this.tweetService = tweetService;
        this.currentUserProfileService = currentUserProfileService;
    }

    @Override
    public void deleteTweet(long tweetId) {
        UserProfile actor = this.currentUserProfileService
                .currentUserProfile();

        UserProfile owner = this.tweetService
                .findTweetById(tweetId)
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Пост с id = %d не существует", tweetId);
                    return new RuntimeException(errorMessage);
                });

        if (!actor.equals(owner)) {
            String errorMessage = String
                    .format("Удаление поста с id = %d запрещено. Пользователь %s не является его владельцем",
                            tweetId,
                            actor.getNickname());
            throw new RuntimeException(errorMessage);
        }
        this.tweetService.deleteTweet(tweetId);
    }
}
