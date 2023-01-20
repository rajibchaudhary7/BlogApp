package com.codeup.blogapp.Contollers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
       model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post currentPost = new Post(id,"Car", "Takes us from A to B.");
        model.addAttribute("post", currentPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreate() {
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String postCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post x = new Post(title, body);
        postDao.save(x);
        return "redirect:/posts";
    }

}
