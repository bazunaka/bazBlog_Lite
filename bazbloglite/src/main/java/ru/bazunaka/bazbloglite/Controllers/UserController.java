package ru.bazunaka.bazbloglite.Controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Entity.Role;
import ru.bazunaka.bazbloglite.Entity.User;
import ru.bazunaka.bazbloglite.Mapper.RegisterRequestToUserMapper;
import ru.bazunaka.bazbloglite.Model.RegisterRequest;
import ru.bazunaka.bazbloglite.Services.RoleService;
import ru.bazunaka.bazbloglite.Services.UserService;
import ru.bazunaka.bazbloglite.Usercase.RegisterUserAccountCase;

import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class UserController {

    private final RegisterUserAccountCase registerUserAccountCase;

    public UserController(RegisterUserAccountCase registerUserAccountCase) {
        this.registerUserAccountCase = registerUserAccountCase;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);

        this.registerUserAccountCase.register(registerRequest);
    }
}
