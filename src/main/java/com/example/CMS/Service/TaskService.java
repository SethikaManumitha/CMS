package com.example.CMS.Service;

import com.example.CMS.DTO.TaskDTO;
import com.example.CMS.DTO.TaskResponseDTO;
import com.example.CMS.Entity.Class;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Entity.Task;
import com.example.CMS.Repository.ClassRepo;
import com.example.CMS.Repository.LecturerRepo;
import com.example.CMS.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LecturerRepo lecturerRepository;

    @Autowired
    private ClassRepo classRepo;

    private static final String FILE_UPLOAD_DIR = "D:\\CMS\\frontend\\CMS_Front\\uploads\\assignments";

    public TaskResponseDTO createTask(TaskDTO taskDTO) {
        Class aClass = classRepo.findById(taskDTO.getClassID())
                .orElseThrow(() -> new IllegalArgumentException("Class not found"));
        Lecturer lecturer = lecturerRepository.findById(taskDTO.getLecturerId())
                .orElseThrow(() -> new IllegalArgumentException("Lecturer not found"));

        File uploadDir = new File(FILE_UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        List<String> fileNames = new ArrayList<>();
        System.out.println(taskDTO.getDocUrl().length);
        if (taskDTO.getDocUrl() != null) {
            for (MultipartFile file : taskDTO.getDocUrl()) {
                try {
                    System.out.println("Received File: " + file.getOriginalFilename());
                    System.out.println("File Size: " + file.getSize() + " bytes");
                    System.out.println("Content Type: " + file.getContentType());

                    String uniqueFileName = System.currentTimeMillis() + "_" + Objects.requireNonNull(file.getOriginalFilename());
                    File targetFile = new File(uploadDir, uniqueFileName);
                    file.transferTo(targetFile);
                    fileNames.add(uniqueFileName);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to upload file: " + file.getOriginalFilename(), e);
                }
            }
        }

        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDue_time(taskDTO.getDueTime());
        task.setDueDate(taskDTO.getDueDate());
        task.setType(taskDTO.getType());
        task.setDescription(taskDTO.getDescription());
        task.setDocUrl(String.join(",", fileNames));  // Store file paths as a comma-separated string
        task.setStatus(taskDTO.getStatus());
        task.setAClass(aClass);
        task.setLecturer(lecturer);

        Task savedTask = taskRepository.save(task);

        return new TaskResponseDTO(
                savedTask.getTitle(),
                savedTask.getDue_time(),
                savedTask.getDueDate(),
                savedTask.getType(),
                savedTask.getDescription(),
                savedTask.getDocUrl(),
                savedTask.getStatus(),
                savedTask.getAClass().getClassID(),
                savedTask.getLecturer().getLecturerID()
        );
    }

    public List<Task> getTasksByCourseId(int courseId) {
        return taskRepository.findTasksByCourseId(courseId);
    }
}
