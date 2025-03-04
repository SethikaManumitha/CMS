package com.example.CMS.Repository;

import com.example.CMS.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Admin entity.
 * Extends JpaRepository to provide CRUD operations on the admin table.
 */
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
