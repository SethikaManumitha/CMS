package com.example.CMS.Repository;

import com.example.CMS.Entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTableRepo extends JpaRepository<Timetable, Integer> {
}
