package com.example.CMS.Repository;

import com.example.CMS.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Department entity.
 * Extends JpaRepository to provide CRUD operations on the Department table.
 */
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
