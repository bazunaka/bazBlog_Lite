package ru.bazunaka.bazbloglite.Controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Model.RegisterRequest;
import ru.bazunaka.bazbloglite.Usecase.RegisterUserAccountCase;

/**
 * Контроллер для управления пользователями.
 * Обрабатывает HTTP-запросы, связанные с регистрацией пользователей.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class UserController {

    private final RegisterUserAccountCase registerUserAccountCase;

    /**
     * Конструктор контроллера пользователей.
     *
     * @param registerUserAccountCase компонент для регистрации пользователей
     */
    public UserController(RegisterUserAccountCase registerUserAccountCase) {
        this.registerUserAccountCase = registerUserAccountCase;
    }

    /**
     * Обрабатывает POST-запрос для регистрации нового пользователя.
     *
     * @param registerRequest запрос на регистрацию пользователя
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);

        this.registerUserAccountCase.register(registerRequest);
    }
}
