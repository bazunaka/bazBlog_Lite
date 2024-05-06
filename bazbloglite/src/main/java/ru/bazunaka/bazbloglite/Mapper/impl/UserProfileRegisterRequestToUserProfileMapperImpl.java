package ru.bazunaka.bazbloglite.Mapper.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Mapper.UserProfileRegisterRequestToUserProfileMapper;
import ru.bazunaka.bazbloglite.Model.CurrentUserModel;
import ru.bazunaka.bazbloglite.Model.UserProfileRegisterRequest;
import ru.bazunaka.bazbloglite.Services.IdentityService;

@Component
public class UserProfileRegisterRequestToUserProfileMapperImpl
    implements UserProfileRegisterRequestToUserProfileMapper {

    private final IdentityService identityService;

    public UserProfileRegisterRequestToUserProfileMapperImpl(IdentityService identityService) {
        this.identityService = identityService;
    }

    @Override
    public UserProfile map(UserProfileRegisterRequest registerRequest) {
        CurrentUserModel currentUserModel = this.identityService
                .currentUserAccount()
                .orElseThrow(() -> new RuntimeException("Для создания профиля пользователь" +
                        " должен быть авторизован в системе"));

        UserProfile userProfile = new UserProfile();

        userProfile.setId(currentUserModel.userAccountId());
        userProfile.setNickname(registerRequest.nickname());
        userProfile.setImageLink(registerRequest.imageLink());

        return userProfile;
    }
}
