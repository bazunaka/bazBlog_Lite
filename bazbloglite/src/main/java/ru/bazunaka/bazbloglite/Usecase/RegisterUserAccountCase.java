package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.RegisterRequest;

public interface RegisterUserAccountCase {
    void register(RegisterRequest registerRequest);
}
