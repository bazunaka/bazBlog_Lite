package ru.bazunaka.bazbloglite.Services;

import ru.bazunaka.bazbloglite.Entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findUserRole();
}
