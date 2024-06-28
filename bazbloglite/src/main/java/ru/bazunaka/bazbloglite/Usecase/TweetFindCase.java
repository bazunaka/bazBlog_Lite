package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.TweetFindRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;

import java.util.Collection;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@Validated
public interface TweetFindCase {
    Collection<TweetResponse> findTweets(@Valid TweetFindRequest findRequest);
}
