package com.example.CMS.Repository;

import com.example.CMS.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventRepo extends JpaRepository<Event,Integer> {
}
