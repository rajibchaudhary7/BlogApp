package com.codeup.blogapp.Contollers;

import com.codeup.blogapp.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String allPosts() {
        return "This will be a page for all of the posts!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewIndividualPost(@PathVariable int id) {
        return "View an individul post with the id of " + id;
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
