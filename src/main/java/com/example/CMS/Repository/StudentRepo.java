package com.example.CMS.Repository;

import com.example.CMS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    Student findByUser_Id(int id);
}
