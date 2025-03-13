package com.example.CMS.Repository;

import com.example.CMS.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * FROM task t WHERE t.course_id = :courseId", nativeQuery = true)
    List<Task> findTasksByCourseId(@Param("courseId") int courseId);

}
