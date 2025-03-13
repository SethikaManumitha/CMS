package com.example.CMS.Repository;

import com.example.CMS.Entity.StudentTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentTaskRepository extends JpaRepository<StudentTask, Integer> {
    // Find StudentTask by taskId
    List<StudentTask> findByTask_TaskId(int taskId);

    // Find StudentTask by studentId
    List<StudentTask> findByStudent_StudentID(int studentId);

    // Find StudentTask by both taskId and studentId
    StudentTask findByTask_TaskIdAndStudent_StudentID(int taskId, int studentId);
}
