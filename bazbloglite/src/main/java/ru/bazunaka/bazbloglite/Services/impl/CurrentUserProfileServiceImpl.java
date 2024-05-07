package ru.bazunaka.bazbloglite.Services.impl;

import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
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
        
        return null;
    }
}
