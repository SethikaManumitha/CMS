package com.example.CMS.Repository;

import com.example.CMS.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Department entity.
 * Extends JpaRepository to provide CRUD operations on the Department table.
 */
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    @Query(value = "SELECT d.dept_id, d.dept_name, r.resourceID, r.capacity, r.description, r.name, r.status, r.type " +
            "FROM department d " +
            "LEFT JOIN resource r ON d.dept_id = r.dept_id", nativeQuery = true)
    List<Object[]> findAllDepartmentsWithResources();

    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.lecturers")
    List<Department> findAllDepartmentsWithLecturers();
}
