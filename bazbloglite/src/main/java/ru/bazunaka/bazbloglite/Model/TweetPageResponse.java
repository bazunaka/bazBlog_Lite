package ru.bazunaka.bazbloglite.Model;

import java.util.Collection;

public record TweetPageResponse(Collection<TweetResponse> tweets) {

}
