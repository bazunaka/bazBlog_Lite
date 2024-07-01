package ru.bazunaka.bazbloglite.Mapper;

import org.springframework.data.domain.Page;

import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Model.TweetPageResponse;

public interface TweetPageToTweetPageResponseMapper extends Mapper<TweetPageResponse, Page<Tweet>>{

}
