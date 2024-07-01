package ru.bazunaka.bazbloglite.Mapper.impl;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Mapper.TweetPageToTweetPageResponseMapper;
import ru.bazunaka.bazbloglite.Mapper.TweetToTweetResponseMapper;
import ru.bazunaka.bazbloglite.Model.TweetPageResponse;
import ru.bazunaka.bazbloglite.Model.TweetResponse;

@Component
public class TweetPageToTweetPageResponseMapperImpl implements TweetPageToTweetPageResponseMapper {

    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;

    public TweetPageToTweetPageResponseMapperImpl(TweetToTweetResponseMapper tweetToTweetResponseMapper) {
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
    }

    @Override
    public TweetPageResponse map(Page<Tweet> source) {
        Collection<TweetResponse> tweetResponses = source
                .stream()
                .map(this.tweetToTweetResponseMapper::map)
                .toList();

        return new TweetPageResponse(source.getTotalElements(),
                                    source.isFirst(),
                                    source.isLast(),
                                    tweetResponses);
    }

}
