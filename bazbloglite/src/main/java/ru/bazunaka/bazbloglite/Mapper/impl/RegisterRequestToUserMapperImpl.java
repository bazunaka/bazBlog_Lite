package ru.bazunaka.bazbloglite.Mapper.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Entity.Role;
import ru.bazunaka.bazbloglite.Entity.User;
import ru.bazunaka.bazbloglite.Mapper.RegisterRequestToUserMapper;
import ru.bazunaka.bazbloglite.Model.RegisterRequest;
import ru.bazunaka.bazbloglite.Services.RoleService;

import java.util.Locale;
import java.util.Set;

@Component
public class RegisterRequestToUserMapperImpl implements RegisterRequestToUserMapper {

    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public RegisterRequestToUserMapperImpl(RoleService roleService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User map(RegisterRequest registerRequest) {
        Role role = this.roleService
                .findUserRole()
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        user.setPassword(this.passwordEncoder.encode(registerRequest.password()));
        user.setAuthorities(Set.of(role));
        return user;
    }
}
