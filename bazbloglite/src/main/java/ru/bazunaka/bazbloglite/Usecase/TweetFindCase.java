package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.TweetFindRequest;
import ru.bazunaka.bazbloglite.Model.TweetPageResponse;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@Validated
public interface TweetFindCase {
    TweetPageResponse findTweets(@Valid TweetFindRequest findRequest);
}
