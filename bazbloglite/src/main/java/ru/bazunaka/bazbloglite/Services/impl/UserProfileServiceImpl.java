package ru.bazunaka.bazbloglite.Services.impl;

import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Entity.UserProfile;
import ru.bazunaka.bazbloglite.Repository.UserProfileRepository;
import ru.bazunaka.bazbloglite.Services.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void createUserProfile(UserProfile userProfile) {
        if(this.userProfileRepository.existsById(userProfile.getId())) {
            String errorMessage = String.format(
                    "Профиль пользователя с данным Id = %d уже был создан",
                    userProfile.getId());
            throw new RuntimeException(errorMessage);
        }

        if(this.userProfileRepository.existsByNickname(userProfile.getNickname())) {
            String errorMessage = String.format(
                    "Профиль пользователя с данным Nickname = %s уже был создан",
                    userProfile.getNickname());
            throw new RuntimeException(errorMessage);
        }

        this.userProfileRepository.save(userProfile);
    }
}
