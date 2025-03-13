package com.example.CMS.Repository;

import com.example.CMS.Entity.EventAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventAttendanceRepository extends JpaRepository<EventAttendance, Long> {
}
