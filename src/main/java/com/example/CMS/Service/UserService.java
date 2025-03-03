package com.example.CMS.Service;

import com.example.CMS.Entity.User;
import com.example.CMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling business logic related to User entity.
 * Provides methods to interact with the User repository.
 */
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo; // Injecting UserRepo dependency

    /**
     * Saves user details to the database.
     * @param user User entity to be saved
     * @return Saved User entity
     */
    public User saveDetails(User user){
        return userRepo.save(user);
    }
}