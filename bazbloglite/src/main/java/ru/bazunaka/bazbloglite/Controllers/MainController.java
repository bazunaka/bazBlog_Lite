package ru.bazunaka.bazbloglite.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Entity.Post;
import ru.bazunaka.bazbloglite.Entity.User;
import ru.bazunaka.bazbloglite.Repository.PostRepository;
import ru.bazunaka.bazbloglite.Repository.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private PostRepository postRepository;
    private UserRepository userRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/home")
    public String main(Map<String, Object> model) {
        Iterable<Post> posts = postRepository.findAll();
        model.put("posts", posts);
        return "home";
    }

    @PostMapping("/home")
    public String add_post(@RequestParam String title, @RequestParam String text, Map<String, Object> model) {
        Post post = new Post(title, text);
        postRepository.save(post);

        Iterable<Post> posts = postRepository.findAll();
        model.put("posts", posts);
        return "home";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Post> posts;
        if (filter != null && !filter.isEmpty()) {
            posts = postRepository.findByTitlePost(filter);
        } else {
            posts = postRepository.findAll();
        }

        model.put("posts", posts);
        return "home";
    }
}