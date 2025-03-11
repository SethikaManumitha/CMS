package com.example.CMS.Repository;

import com.example.CMS.Entity.ReservationEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationEventRepository extends JpaRepository<ReservationEvent,Integer> {
}
