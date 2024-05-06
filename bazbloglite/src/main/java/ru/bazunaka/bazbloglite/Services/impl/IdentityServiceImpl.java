package ru.bazunaka.bazbloglite.Services.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Model.CurrentUserModel;
import ru.bazunaka.bazbloglite.Services.IdentityService;
import ru.bazunaka.bazbloglite.Services.UserService;

import java.util.Optional;

@Service
public class IdentityServiceImpl implements IdentityService {

    private final UserService userService;

    public IdentityServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<CurrentUserModel> currentUserAccount() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(Authentication::getName)
                .flatMap(username -> this.userService.findUserByUsername(username)
                            .map(user -> new CurrentUserModel(user.getId())));

//        Authentication = securityContext.getAuthentication();
//
//        if (authentication == null) {
//            return Optional.empty();
//        }
//
//        String username = authentication.getName();
//        return this.userService.findUserByUsername(username)
//                .map(user -> new CurrentUserModel(user.getId()));
    }
}
