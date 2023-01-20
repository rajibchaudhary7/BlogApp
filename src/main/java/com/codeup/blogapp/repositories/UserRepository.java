package com.codeup.blogapp.repositories;
import com.codeup.blogapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{

}
