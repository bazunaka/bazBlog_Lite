package ru.bazunaka.bazbloglite.Controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Model.UserProfileRegisterRequest;
import ru.bazunaka.bazbloglite.Usecase.UserProfileRegisterCase;

/**
 * Контроллер для управления профилями пользователей.
 * Обрабатывает HTTP-запросы, связанные с регистрацией профилей пользователей.
 */
@RestController
@RequestMapping("/api/v1/user-profiles")
public class UserProfileController {

    private final UserProfileRegisterCase registerCase;

    /**
     * Конструктор контроллера профилей пользователей.
     *
     * @param registerCase компонент для регистрации профилей пользователей
     */
    public UserProfileController(UserProfileRegisterCase registerCase) {
        this.registerCase = registerCase;
    }

    /**
     * Обрабатывает POST-запрос для регистрации нового профиля пользователя.
     *
     * @param registerRequest запрос на регистрацию профиля пользователя
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest registerRequest) {
        this.registerCase.registerUserProfile(registerRequest);
    }
}
