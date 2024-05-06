package ru.bazunaka.bazbloglite.Model;

import jakarta.validation.constraints.NotBlank;

public record UserProfileRegisterRequest(@NotBlank String nickname,
                                         @NotBlank String imageLink) {

}
