package ru.bazunaka.bazbloglite.Services;

import ru.bazunaka.bazbloglite.Entity.UserProfile;

import java.util.Optional;

public interface UserProfileService {

    void createUserProfile(UserProfile userProfile);

    Optional<UserProfile> findUserProfileById(long userProfileId);
}
