package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.TweetResponse;

import java.util.Collection;

public interface TweetFindCase {
    Collection<TweetResponse> findTweets();
}
