package ru.bazunaka.bazbloglite.Mapper.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Tweet;
import ru.bazunaka.bazbloglite.Mapper.TweetToTweetResponseMapper;
import ru.bazunaka.bazbloglite.Model.TweetResponse;

@Component
public class TweetToTweetResponseMapperImpl implements TweetToTweetResponseMapper {
    @Override
    public TweetResponse map(Tweet model) {
        return new TweetResponse(
                model.getId(),
                model.getMessage(),
                model.getCreatedTime()
        );
    }
}
