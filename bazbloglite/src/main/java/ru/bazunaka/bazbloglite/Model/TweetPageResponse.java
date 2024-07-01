package ru.bazunaka.bazbloglite.Model;

import java.util.Collection;

public record TweetPageResponse(
    long totalTweets,
    boolean isFirstPage,
    boolean isLastPage,
    Collection<TweetResponse> tweets) {
        
}
