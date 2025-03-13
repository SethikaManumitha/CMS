package com.example.CMS.Service;

import com.example.CMS.DTO.TaskDTO;
import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Entity.Task;
import com.example.CMS.Repository.CourseRepo;
import com.example.CMS.Repository.LecturerRepo;
import com.example.CMS.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private LecturerRepo lecturerRepository;

    public Task createTask(TaskDTO taskDTO) {
        Course course = courseRepository.findById(taskDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        Lecturer lecturer = lecturerRepository.findById(taskDTO.getLecturerId())
                .orElseThrow(() -> new IllegalArgumentException("Lecturer not found"));

        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDate(taskDTO.getDate());
        task.setDueDate(taskDTO.getDueDate());
        task.setDescription(taskDTO.getDescription());
        task.setDocUrl(taskDTO.getDocUrl());
        task.setStatus(taskDTO.getStatus());
        task.setCourse(course);
        task.setLecturer(lecturer);

        return taskRepository.save(task);
    }
    public List<Task> getTasksByCourseId(int courseId) {
        return taskRepository.findTasksByCourseId(courseId);
    }
}
