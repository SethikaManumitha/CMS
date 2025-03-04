package com.example.CMS.Repository;

import com.example.CMS.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for User entity.
 * Extends JpaRepository to provide CRUD operations on the users table.
 */
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
