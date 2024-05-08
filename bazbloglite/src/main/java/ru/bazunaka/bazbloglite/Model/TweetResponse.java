package ru.bazunaka.bazbloglite.Model;

import java.time.Instant;

public record TweetResponse(
        long id,
        String message,
        Instant createdTime,
        Instant modifiedTime
) {
}
