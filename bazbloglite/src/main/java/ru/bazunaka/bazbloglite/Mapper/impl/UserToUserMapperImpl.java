package ru.bazunaka.bazbloglite.Mapper.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import ru.bazunaka.bazbloglite.Mapper.UserToUserMapper;

@Component
public class UserToUserMapperImpl implements UserToUserMapper {
    @Override
    public User map(ru.bazunaka.bazbloglite.Entity.User user) {
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities());
    }
}
