package com.example.CMS.Service;

import com.example.CMS.DTO.ClassResponse;
import com.example.CMS.DTO.ReservationClassResponse;
import com.example.CMS.DTO.ReservationEventResponse;
import com.example.CMS.Entity.*;
import com.example.CMS.Entity.Class;
import com.example.CMS.Repository.ReservationClassRepo;
import com.example.CMS.Repository.ReservationEventRepo;
import com.example.CMS.Repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ReservationClass reserveClass(Class assignedClass, Resource resource, String date, String startTime, String endTime) {
        if (isResourceAvailable(resource, date, startTime, endTime)) {
            ReservationClass reservation = new ReservationClass();
            reservation.setAssignedClass(assignedClass);
            reservation.setResource(resource);
            reservation.setStartTime(startTime);
            reservation.setEndTime(endTime);
            reservation.setReservationDate(date);
            reservation.setStatus("Pending");

            // Save the reservation object to the database
            return reservationClassRepo.save(reservation);
        } else {
            throw new IllegalArgumentException("Resource is already reserved during this time");
        }
    }


    public List<ReservationClassResponse> getReservationsByDate(String reservationDate) {
        List<ReservationClass> reservationClasses = reservationClassRepo.findByReservationDate(reservationDate);

        return reservationClasses.stream().map(reservation -> {
            // Return the relevant reservation class details along with resource room name
            return new ReservationClassResponse(
                    reservation.getReservationID(),
                    reservation.getAssignedClass().getClassID(),
                    reservation.getAssignedClass().getCourse().getCourseID(),
                    reservation.getAssignedClass().getCourse().getCourseName(),
                    reservation.getAssignedClass().getLecturer().getLecturerID(),
                    reservation.getAssignedClass().getLecturer().getUser().getFirstName() + " " + reservation.getAssignedClass().getLecturer().getUser().getLastName(),
                    reservation.getResource().getResourceID(),
                    reservation.getResource().getName(),
                    reservation.getReservationDate(),
                    reservation.getStartTime(),
                    reservation.getEndTime()
            );
        }).collect(Collectors.toList());
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

    public List<ReservationClassResponse> getAllClasses(){
        List<ReservationClass> reservationClasses =  reservationClassRepo.findByStatus("Pending");

        return reservationClasses.stream().map(clazz ->
                new ReservationClassResponse(
                        clazz.getReservationID(),
                        clazz.getAssignedClass().getClassID(),
                        clazz.getAssignedClass().getCourse().getCourseID(),
                        clazz.getAssignedClass().getCourse().getCourseName(),
                        clazz.getAssignedClass().getLecturer().getLecturerID(),
                        clazz.getAssignedClass().getLecturer().getUser().getFirstName() + " " + clazz.getAssignedClass().getLecturer().getUser().getLastName(),
                        clazz.getResource().getResourceID(),
                        clazz.getResource().getName(),
                        clazz.getReservationDate(),
                        clazz.getStartTime(),
                        clazz.getEndTime()
                )
        ).collect(Collectors.toList());
    }

    public List<ReservationEventResponse> getAllEvents(){
        List<ReservationEvent> reservationEvents =  reservationEventRepo.findAll();

        return reservationEvents.stream().map(event ->
                new ReservationEventResponse(
                        event.getReservationID(),
                        event.getEvent().getEventID(),
                        event.getEvent().getName(),
                        event.getResource().getResourceID(),
                        event.getResource().getName(),
                        event.getReservationDate(),
                        event.getStartTime(),
                        event.getEndTime()
                )
        ).collect(Collectors.toList());
    }

    public Optional<ReservationClass> getReservationById(int reservationId) {
        return reservationClassRepo.findById(reservationId);
    }

    public ReservationClass saveReservation(ReservationClass reservation) {
        return reservationClassRepo.save(reservation);
    }

}
