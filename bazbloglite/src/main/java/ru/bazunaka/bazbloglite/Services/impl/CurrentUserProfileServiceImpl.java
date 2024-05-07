package ru.bazunaka.bazbloglite.Services.impl;

import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Model.CurrentUserModel;
import ru.bazunaka.bazbloglite.Services.CurrentUserProfileService;
import ru.bazunaka.bazbloglite.Services.IdentityService;
import ru.bazunaka.bazbloglite.Services.UserProfileService;

@Service
public class CurrentUserProfileServiceImpl implements CurrentUserProfileService {

    private final IdentityService identityService;
    private final UserProfileService userProfileService;

    public CurrentUserProfileServiceImpl(IdentityService identityService, UserProfileService userProfileService) {
        this.identityService = identityService;
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile currentUserProfile() {
        CurrentUserModel currentUserModel = this.identityService.currentUserAccount()
                .orElseThrow(() -> new RuntimeException("Пользователь должен быть авторизован"));
        return this.userProfileService
                .findUserProfileById(currentUserModel.userAccountId())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Профиль пользователя с id = %d не существует",
                            currentUserModel.userAccountId());
                    return new RuntimeException(errorMessage);
                });
    }
}
