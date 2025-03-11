package com.example.CMS.Repository;

import com.example.CMS.Entity.ReservationEvent;
import com.example.CMS.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationEventRepo extends JpaRepository<ReservationEvent,Integer> {

    // JPQL to check conflict in resource reservation
    @Query("SELECT COUNT(r) > 0 FROM ReservationEvent r " +
            "WHERE r.resource = :resource " +
            "AND r.reservationDate = :date " +
            "AND (r.startTime < :newEnd AND r.endTime > :newStart)")
    boolean existsByResourceAndTimeConflict(@Param("resource") Resource resource,
                                            @Param("date") String date,
                                            @Param("newStart") String newStart,
                                            @Param("newEnd") String newEnd);


}
