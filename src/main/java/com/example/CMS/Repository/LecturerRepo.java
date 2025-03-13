package com.example.CMS.Repository;

import com.example.CMS.Entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Lecturer entity.
 * Extends JpaRepository to provide CRUD operations on the Lecturer table.
 */

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Integer> {
    @Query(value = "SELECT " +
            "u.id AS user_id, " +
            "u.first_name, " +
            "u.last_name, " +
            "u.email, " +
            "u.phone_number, " +
            "u.address, " +
            "u.dob, " +
            "u.gender, " +
            "u.role, " +
            "u.status, " +
            "l.lecturerID, " +
            "l.designation, " +
            "l.specialisation, " +
            "l.highest_qualification, " +
            "d.dept_id AS department_id, " +
            "d.dept_name AS department_name " +
            "FROM users u " +
            "LEFT JOIN lecturer l ON u.id = l.user_id " +
            "LEFT JOIN department d ON d.dept_id = l.dept_id " +
            "WHERE l.lecturerID IS NOT NULL", nativeQuery = true)
    List<Object[]> findLecturersAndDepartments();
}
