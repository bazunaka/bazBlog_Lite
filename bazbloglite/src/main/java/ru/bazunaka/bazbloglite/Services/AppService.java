package ru.bazunaka.bazbloglite.Services;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.bazunaka.bazbloglite.Entity.Application;
import ru.bazunaka.bazbloglite.Entity.User;
import ru.bazunaka.bazbloglite.Repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AppService {
    private List<Application> applications;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void loadAppInDb() {

    }

    public List<Application> allApplications() {
        return applications;
    }

    public Application applicationByID(int id) {
        return applications.stream()
                .filter(app -> app.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
