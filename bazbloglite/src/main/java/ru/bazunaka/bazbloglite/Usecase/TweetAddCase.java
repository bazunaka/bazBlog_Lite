package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.TweetAddRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;

public interface TweetAddCase {
    TweetResponse addTweet(TweetAddRequest addRequest);
}
