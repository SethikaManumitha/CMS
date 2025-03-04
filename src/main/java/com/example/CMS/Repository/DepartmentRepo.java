package com.example.CMS.Repository;

import com.example.CMS.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Department entity.
 * Extends JpaRepository to provide CRUD operations on the Department table.
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
