package ru.bazunaka.bazbloglite.Services;

import ru.bazunaka.bazbloglite.Model.CurrentUserModel;

import java.util.Optional;

public interface IdentityService {
    Optional<CurrentUserModel> currentUserAccount();
}
