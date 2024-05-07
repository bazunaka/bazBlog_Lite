package ru.bazunaka.bazbloglite.Usecase.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Mapper.TweetEditRequestToTweetMapper;
import ru.bazunaka.bazbloglite.Mapper.TweetToTweetResponseMapper;
import ru.bazunaka.bazbloglite.Model.TweetEditRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;
import ru.bazunaka.bazbloglite.Services.CurrentUserProfileService;
import ru.bazunaka.bazbloglite.Services.TweetService;
import ru.bazunaka.bazbloglite.Usecase.TweetEditCase;

@Component
public class TweetEditCaseFacade implements TweetEditCase {

    private final TweetService tweetService;
    private final TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final CurrentUserProfileService currentUserProfileService;

    public TweetEditCaseFacade(TweetService tweetService,
                               TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper,
                               TweetToTweetResponseMapper tweetToTweetResponseMapper,
                               CurrentUserProfileService currentUserProfileService) {
        this.tweetService = tweetService;
        this.tweetEditRequestToTweetMapper = tweetEditRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.currentUserProfileService = currentUserProfileService;
    }

    @Override
    public TweetResponse editTweet(TweetEditRequest editRequest) {
        UserProfile actor = this.currentUserProfileService.currentUserProfile();
        UserProfile owner = this.tweetService.findTweetById(editRequest.id())
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Пост с id = %d не существует", editRequest.id());
                    return new RuntimeException(errorMessage);
                });

        if (!actor.equals(owner)) {
            String errorMessage = String
                    .format("Редактирование поста с id = %d запрещено. Пользователь %s не является его владельцем",
                            editRequest.id(),
                            actor.getNickname());
            throw new RuntimeException(errorMessage);
        }

        Tweet tweet = this.tweetEditRequestToTweetMapper.map(editRequest);
        Tweet updatedTweet = this.tweetService.updateTweet(tweet);

        return this.tweetToTweetResponseMapper.map(updatedTweet);
    }
}
