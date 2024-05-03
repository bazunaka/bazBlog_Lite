package ru.bazunaka.bazbloglite.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Model.RegisterRequest;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts/register")
public class UserController {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);
    }
}
