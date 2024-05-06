package ru.bazunaka.bazbloglite.Controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Model.UserProfileRegisterRequest;
import ru.bazunaka.bazbloglite.Usecase.UserProfileRegisterCase;

@RestController
@RequestMapping("/api/v1/user-profiles")
public class UserProfileController {

    private final UserProfileRegisterCase registerCase;

    public UserProfileController(UserProfileRegisterCase registerCase) {
        this.registerCase = registerCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest registerRequest) {
        this.registerCase.registerUserProfile(registerRequest);
    }
}
