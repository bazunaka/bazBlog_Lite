//package ru.bazunaka.bazbloglite.Controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.bazunaka.bazbloglite.Entity.Post;
//import ru.bazunaka.bazbloglite.Entity.User;
//import ru.bazunaka.bazbloglite.Repository.PostRepository;
//import ru.bazunaka.bazbloglite.Repository.UserRepository;
//import ru.bazunaka.bazbloglite.Services.AppService;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@Controller
//public class MainController {
//    private AppService service;
//    @Autowired
//    private PostRepository postRepository;
//    private UserRepository userRepository;
//
////    @GetMapping("/")
////    public String greeting(Map<String, Object> model) {
////        return "main";
////    }
//
//    @GetMapping("/")
//    public String main(Map<String, Object> model) {
//        Iterable<Post> posts = postRepository.findAll();
//        model.put("posts", posts);
//        return "home";
//    }
//
//    @PostMapping("/")
//    public String add_post(@RequestParam String title, @RequestParam String text, Map<String, Object> model) {
//        Post post = new Post(title, text);
//        postRepository.save(post);
//
//        Iterable<Post> posts = postRepository.findAll();
//        model.put("posts", posts);
//        return "home";
//    }
//
//    @PostMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model) {
//        Iterable<Post> posts;
//        if (filter != null && !filter.isEmpty()) {
//            posts = postRepository.findByTitlePost(filter);
//        } else {
//            posts = postRepository.findAll();
//        }
//
//        model.put("posts", posts);
//        return "home";
//    }
//
//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String addUser(@RequestParam String userName, @RequestParam String password, Map<String, Object> model) {
//        User user = new User(userName, password);
//        userRepository.save(user);
//
//        Iterable<User> users = userRepository.findAll();
//        model.put("users", users);
//
//        return "redirect:/login";
//    }
//}

package ru.bazunaka.bazbloglite.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
    @GetMapping("/")
    public String greeting() {
        return "home";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }
    @GetMapping("/employee")
    public String employee() {
        return "employee";
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}