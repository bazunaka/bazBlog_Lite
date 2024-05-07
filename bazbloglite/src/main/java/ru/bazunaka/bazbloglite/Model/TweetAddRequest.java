package ru.bazunaka.bazbloglite.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TweetAddRequest(
        @NotBlank
        @Size(min = 10, max = 180)
        String message) {
}
