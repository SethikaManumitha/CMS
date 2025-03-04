package com.example.CMS.Service;

import com.example.CMS.Entity.User;
import com.example.CMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * Updates a user by ID.
     * @param id ID of the user to be updated
     * @param user User entity with updated data
     * @return Updated User entity
     */
    public User updateUser(Integer id,User user){
        User existingUser = userRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setAddress(user.getAddress());
        existingUser.setDob(user.getDob());
        existingUser.setGender(user.getGender());
        existingUser.setRole(user.getRole());
        existingUser.setStatus(user.getStatus());

        return userRepo.save(existingUser);
    }

    /**
     * Deletes a user by ID.
     * @param id ID of the user to be deleted
     */
    public void deleteUser(int id) {
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepo.deleteById(id);
    }

    /**
     * Fetches a user by ID.
     * @param id ID of the user to be fetched
     * @return User entity
     */
    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Fetches all users.
     * @return List of all User entities
     */
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}