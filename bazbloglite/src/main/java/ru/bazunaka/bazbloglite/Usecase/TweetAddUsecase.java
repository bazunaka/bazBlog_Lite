package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.TweetAddRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;

public interface TweetAddUsecase {
    TweetResponse addTweet(TweetAddRequest addRequest);
}
