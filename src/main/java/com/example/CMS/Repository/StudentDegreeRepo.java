package com.example.CMS.Repository;

import com.example.CMS.Entity.StudentDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDegreeRepo extends JpaRepository<StudentDegree, Integer> {
}
