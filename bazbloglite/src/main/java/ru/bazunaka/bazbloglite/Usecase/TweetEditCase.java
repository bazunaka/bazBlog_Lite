package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.TweetEditRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;

public interface TweetEditCase {
    TweetResponse editTweet(TweetEditRequest editRequest);
}
