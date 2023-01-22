package com.codeup.blogapp.Contollers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository usersDao){
        this.postDao = postDao;
        this.userDao = usersDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
       model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){
        model.addAttribute("title", "Individual Post");
        model.addAttribute("post", postDao.findById(id));
        Post post = postDao.getReferenceById(id);
        User user = userDao.getReferenceById(post.getUser().getId());
        model.addAttribute("postTitle", post.getTitle());
        model.addAttribute("postBody", post.getBody());
        model.addAttribute("postID", post.getId());
        model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("user", user);
        return "posts/show";
    }

//    @GetMapping("/posts/create")
//    public String getCreate() {
//        return "posts/create";
//    }
//
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    public String postCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
//        Post x = new Post(title, body);
//        postDao.save(x);
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/create")
    public String getForm(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User user = userDao.getReferenceById(1L);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

}
