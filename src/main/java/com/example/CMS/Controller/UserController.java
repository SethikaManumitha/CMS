package com.example.CMS.Controller;

import com.example.CMS.Entity.User;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public User addUser(@RequestBody User user)
    {
        return userService.saveDetails(user);
    }

    /**
     * Handles HTTP PUT requests to update an existing user.
     * @param id User ID
     * @param user User entity with updated details
     * @return Updated User entity
     */
    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Handles HTTP DELETE requests to delete an existing user.
     * @param id User ID
     */
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    /**
     * Handles HTTP GET requests to fetch a user by ID.
     * @param id User ID
     * @return User entity
     */
    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    /**
     * Handles HTTP GET requests to fetch all users.
     * @return List of all User entities
     */
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}