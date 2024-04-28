package ru.bazunaka.bazbloglite.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Entity.Post;
import ru.bazunaka.bazbloglite.Repository.PostRepository;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Post> posts = postRepository.findAll();
        model.put("posts", posts);
        return "home";
    }

    @PostMapping
    public String add_post(@RequestParam String title, @RequestParam String text, Map<String, Object> model) {
        Post post = new Post(title, text);
        postRepository.save(post);

        Iterable<Post> posts = postRepository.findAll();
        model.put("posts", posts);
        return "home";
    }
}