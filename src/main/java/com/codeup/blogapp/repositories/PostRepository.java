package com.codeup.blogapp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.blogapp.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    Post findByTitle(String title);

    Post findByBody(String body);
}
