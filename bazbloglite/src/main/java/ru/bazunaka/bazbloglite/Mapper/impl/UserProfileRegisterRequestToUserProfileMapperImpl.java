package ru.bazunaka.bazbloglite.Mapper.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Mapper.UserProfileRegisterRequestToUserProfileMapper;
import ru.bazunaka.bazbloglite.Model.UserProfileRegisterRequest;

@Component
public class UserProfileRegisterRequestToUserProfileMapperImpl
    implements UserProfileRegisterRequestToUserProfileMapper {
    @Override
    public UserProfile map(UserProfileRegisterRequest registerRequest) {
        UserProfile userProfile = new UserProfile();

        userProfile.setId(1L);
        userProfile.setNickname(registerRequest.nickname());
        userProfile.setImageLink(registerRequest.imageLink());

        return userProfile;
    }
}
