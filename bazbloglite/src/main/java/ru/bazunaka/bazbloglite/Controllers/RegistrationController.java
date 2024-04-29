package ru.bazunaka.bazbloglite.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bazunaka.bazbloglite.Entity.Role;
import ru.bazunaka.bazbloglite.Entity.User;
import ru.bazunaka.bazbloglite.Repository.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String userName, @RequestParam String password, Map<String, Object> model) {
//        User userFromDb = userRepository.findByUserName(user.getUserName());
//
//        if (userFromDb != null) {
//            model.put("message", "User exists!");
//            return "registration";
//        }
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
        User user = new User(userName, password);
        userRepository.save(user);

        Iterable<User> users = userRepository.findAll();
        model.put("users", users);

        return "redirect:/login";
    }
}
