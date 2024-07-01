package ru.bazunaka.bazbloglite.Model;

import jakarta.validation.constraints.NotNull;

public record SubscribeRequest(@NotNull Long followedId) {

}
