package com.example.CMS.Controller;

import com.example.CMS.Entity.User;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling user-related API endpoints.
 * Manages HTTP requests related to User entity operations.
 */
@RestController
@RequestMapping("/user") // Added request mapping
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Handles HTTP POST requests to add a new user.
     * @param user User entity received in the request body
     * @return Saved User entity
     */
    @PostMapping("/addUser")
    public User postDetails(@RequestBody User user)
    {
        return userService.saveDetails(user);
    }
}