package com.example.CMS.Repository;

import com.example.CMS.Entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Lecturer entity.
 * Extends JpaRepository to provide CRUD operations on the Lecturer table.
 */

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Integer> {
}
