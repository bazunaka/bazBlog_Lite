package ru.bazunaka.bazbloglite.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Entity.Role;
import ru.bazunaka.bazbloglite.Entity.User;
import ru.bazunaka.bazbloglite.Model.RegisterRequest;
import ru.bazunaka.bazbloglite.Services.RoleService;
import ru.bazunaka.bazbloglite.Services.UserService;

import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);
        
        Role role = this.roleService
                .findUserRole()
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        user.setPassword(this.passwordEncoder.encode(registerRequest.password()));
        user.setAuthorities(Set.of(role));

        this.userService.createUserAccount(user);
    }
}
