package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.UserProfileRegisterRequest;

public interface UserProfileRegisterCase {
    void registerUserProfile(UserProfileRegisterRequest registerRequest);
}
