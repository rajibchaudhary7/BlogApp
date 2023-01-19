package com.codeup.blogapp.Contollers;

import com.codeup.blogapp.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String allPosts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("TV", "Watch when you need a break."));
        posts.add(new Post("Coffee", "Drink when you feel low."));
        model.addAttribute("allPosts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post currentPost = new Post(id,"Car", "Takes us from A to B.");
        model.addAttribute("post", currentPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreate() {
        return "Form for creating a post!";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreate() {
        return "Posts the create a post page!";
    }

}
