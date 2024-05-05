package ru.bazunaka.bazbloglite.Services.impl;

import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Mapper.UserToUserMapper;
import ru.bazunaka.bazbloglite.Services.UserService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final UserToUserMapper mapper;

    public UserDetailsServiceImpl(UserService userService, UserToUserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userService
                .findUserByUsername(username)
                .map(this.mapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("Неверные учетные данные пользователя"));
    }
}
