package com.example.CMS.Repository;

import com.example.CMS.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entity.
 * Extends JpaRepository to provide CRUD operations on the users table.
 */
public interface UserRepo extends JpaRepository<User,Integer> {
}
