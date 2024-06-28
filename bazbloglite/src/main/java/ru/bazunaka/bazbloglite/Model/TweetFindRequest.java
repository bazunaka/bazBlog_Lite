package ru.bazunaka.bazbloglite.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record TweetFindRequest(
        @Min(0) int page,
        @Min(5) @Max(100) int limit) {

}
