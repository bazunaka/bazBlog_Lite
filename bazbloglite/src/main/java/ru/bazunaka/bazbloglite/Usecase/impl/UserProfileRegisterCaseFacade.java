package ru.bazunaka.bazbloglite.Usecase.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Mapper.UserProfileRegisterRequestToUserProfileMapper;
import ru.bazunaka.bazbloglite.Usecase.UserProfileRegisterCase;
import ru.bazunaka.bazbloglite.Model.UserProfileRegisterRequest;
import ru.bazunaka.bazbloglite.Services.UserProfileService;

@Component
public class UserProfileRegisterCaseFacade implements UserProfileRegisterCase {

    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper mapper;

    public UserProfileRegisterCaseFacade(UserProfileService userProfileService,
                                         UserProfileRegisterRequestToUserProfileMapper mapper) {
        this.userProfileService = userProfileService;
        this.mapper = mapper;
    }

    @Override
    public void registerUserProfile(UserProfileRegisterRequest registerRequest) {
        UserProfile userProfile = this.mapper.map(registerRequest);
        this.userProfileService.createUserProfile(userProfile);
    }
}
