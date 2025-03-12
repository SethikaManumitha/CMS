package com.example.CMS.Service;

import com.example.CMS.Entity.*;
import com.example.CMS.Entity.Class;
import com.example.CMS.Repository.ReservationClassRepo;
import com.example.CMS.Repository.ReservationEventRepo;
import com.example.CMS.Repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationClassRepo reservationClassRepo;

    @Autowired
    private ReservationEventRepo reservationEventRepo;

    @Autowired
    private ResourceRepo resourceRepo;

    public boolean isResourceAvailable(Resource resource, String date, String startTime, String endTime) {
        boolean isReservedForClass = reservationClassRepo.existsByResourceAndTimeConflict(resource, date, startTime, endTime);

        // You can also check for event reservations if needed
        boolean isReservedForEvent = reservationEventRepo.existsByResourceAndTimeConflict(resource, date, startTime, endTime);

        return !isReservedForClass && !isReservedForEvent;
    }

    // Reserve resource for class
    public ReservationClass reserveClass(Class assignedClass, Resource resource, String date, String startTime, String endTime, String reservationName, Integer capacity) {
        if (isResourceAvailable(resource, date, startTime, endTime)) {
            ReservationClass reservation = new ReservationClass();
            reservation.setAssignedClass(assignedClass);
            reservation.setResource(resource);
            reservation.setStartTime(startTime);
            reservation.setEndTime(endTime);
            reservation.setReservationDate(date);
            reservation.setReservationName(reservationName);
            reservation.setCapacity(capacity);
            reservation.setStatus("Pending");

            // Save the reservation object to the database
            return reservationClassRepo.save(reservation);
        } else {
            throw new IllegalArgumentException("Resource is already reserved during this time");
        }
    }


    // Reserve resource for event
    public ReservationEvent reserveEvent(Event assignedEvent, Resource resource, String date, String startTime, String endTime, String reservationName, Integer capacity) {
        if (isResourceAvailable(resource, date, startTime, endTime)) {
            ReservationEvent reservation = new ReservationEvent();
            reservation.setEvent(assignedEvent);
            reservation.setResource(resource);
            reservation.setStartTime(startTime);
            reservation.setEndTime(endTime);
            reservation.setReservationDate(date);
            reservation.setReservationName(reservationName);
            reservation.setCapacity(capacity);
            reservation.setStatus("Reserved");

            // Save the reservation object to the database
            return reservationEventRepo.save(reservation);
        } else {
            throw new IllegalArgumentException("Resource is already reserved during this time");
        }
    }

}
