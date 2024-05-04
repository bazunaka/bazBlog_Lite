package ru.bazunaka.bazbloglite.Usercase.impl;

import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.User;
import ru.bazunaka.bazbloglite.Mapper.RegisterRequestToUserMapper;
import ru.bazunaka.bazbloglite.Model.RegisterRequest;
import ru.bazunaka.bazbloglite.Services.UserService;
import ru.bazunaka.bazbloglite.Usercase.RegisterUserAccountCase;

@Component
public class RegisterUserAccountCaseFacade implements RegisterUserAccountCase {

    private final UserService userService;
    private final RegisterRequestToUserMapper mapper;

    public RegisterUserAccountCaseFacade(UserService userService, RegisterRequestToUserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        User user = this.mapper.map(registerRequest);
        this.userService.createUserAccount(user);
    }
}
