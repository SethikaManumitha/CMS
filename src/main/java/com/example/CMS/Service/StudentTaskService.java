package com.example.CMS.Service;

import com.example.CMS.Entity.StudentTask;
import com.example.CMS.Repository.StudentTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTaskService {

    @Autowired
    private StudentTaskRepository studentTaskRepository;

    public StudentTask createStudentTask(StudentTask studentTask) {
        return studentTaskRepository.save(studentTask);
    }

    public StudentTask getStudentTask(int studentTaskId) {
        return studentTaskRepository.findById(studentTaskId).orElse(null);
    }

    public List<StudentTask> getStudentTasksByTaskId(int taskId) {
        return studentTaskRepository.findByTask_TaskId(taskId);
    }

    public List<StudentTask> getStudentTasksByStudentId(int studentId) {
        return studentTaskRepository.findByStudent_StudentID(studentId);
    }

    public StudentTask getStudentTaskByTaskIdAndStudentId(int taskId, int studentId) {
        return studentTaskRepository.findByTask_TaskIdAndStudent_StudentID(taskId, studentId);
    }
}
