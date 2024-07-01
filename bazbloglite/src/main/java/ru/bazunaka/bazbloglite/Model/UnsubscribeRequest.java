package ru.bazunaka.bazbloglite.Model;

import jakarta.validation.constraints.NotNull;

public record UnsubscribeRequest(@NotNull Long followedId) {

}
