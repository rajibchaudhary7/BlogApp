//package com.codeup.blogapp.services;
//
//
//import com.codeup.blogapp.models.Post;
//import com.codeup.blogapp.repositories.PostRepository;
//import com.codeup.blogapp.repositories.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service("PostService")
//public class PostService {
//
//    private final PostRepository postDao;
//    private final UserRepository userDao;
//    private final EmailService emailService;
//
//    public PostService(PostRepository postDao, UserRepository usersDao, EmailService emailService){
//        this.postDao = postDao;
//        this.userDao = usersDao;
//        this.emailService = emailService;
//    }
//    public List<Post> getAllPosts(){
//        for(Post post: postDao.findAll()){
//            System.out.println("Username: " + post.getUser().getUsername());
//            System.out.println("Title: " + post.getTitle());
//            System.out.println("Body" + post.getBody());
//        }
//        return postDao.findAll();
//    }
//}
