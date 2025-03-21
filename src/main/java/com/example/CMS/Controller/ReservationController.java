package com.example.CMS.Controller;

import com.example.CMS.DTO.AvailabilityRequest;
import com.example.CMS.DTO.ReservationClassResponse;
import com.example.CMS.DTO.ReservationEventResponse;
import com.example.CMS.Entity.*;
import com.example.CMS.Entity.Class;
import com.example.CMS.Service.ClassService;
import com.example.CMS.Service.EventService;
import com.example.CMS.Service.ReservationService;
import com.example.CMS.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClassService classService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private EventService eventService;

    // Check if a resource is available
    @PostMapping("/check-availability")
    public ResponseEntity<Boolean> checkAvailability(@RequestBody AvailabilityRequest request) {
        try {
            Resource resource = resourceService.getResourceById(request.getResourceId())
                    .orElseThrow(() -> new RuntimeException("Resource not found"));

            boolean isAvailable = reservationService.isResourceAvailable(resource,
                    request.getDate(),
                    request.getStartTime(),
                    request.getEndTime());

            return ResponseEntity.ok(isAvailable);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

    // Reserve a resource for a class
    @PostMapping("/class")
    public ResponseEntity<?> reserveClass(@RequestBody ReservationClass reservationRequest) {

        try {
            System.out.println(reservationRequest.getAssignedClass().getClassID());
            Class assignedClass = classService.getClassById(reservationRequest.getAssignedClass().getClassID())
                    .orElseThrow(() -> new RuntimeException("Class not found"));

            Resource resource = resourceService.getResourceById(reservationRequest.getResource().getResourceID())
                    .orElseThrow(() -> new RuntimeException("Resource not found"));

            ReservationClass reservation = reservationService.reserveClass(assignedClass, resource, reservationRequest.getReservationDate(),
                    reservationRequest.getStartTime(), reservationRequest.getEndTime());
            return ResponseEntity.ok(reservation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Reserve a resource for an event
    @PostMapping("/event")
    public ResponseEntity<?> reserveEvent(@RequestBody ReservationEvent reservationRequest) {

        try {
            Event event = eventService.getEventById(reservationRequest.getEvent().getEventID())
                    .orElseThrow(() -> new RuntimeException("Event not found"));

            Resource resource = resourceService.getResourceById(reservationRequest.getResource().getResourceID())
                    .orElseThrow(() -> new RuntimeException("Resource not found"));

            ReservationEvent reservation = reservationService.reserveEvent(event, resource, reservationRequest.getReservationDate(),
                    reservationRequest.getStartTime(), reservationRequest.getEndTime(),reservationRequest.getReservationName(), reservationRequest.getCapacity());
            return ResponseEntity.ok(reservation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/class")
    public List<ReservationClassResponse> getAllClassReservation(){
        return  reservationService.getAllClasses();
    }

    @GetMapping("/event")
    public List<ReservationEventResponse> getAllEventReservation(){
        return  reservationService.getAllEvents();
    }

    @PutMapping("/class/{reservationId}/status")
    public ResponseEntity<?> updateReservationStatus(@PathVariable int reservationId, @RequestBody String newStatus) {
        try {
            // Fetch the reservation by ID
            ReservationClass reservation = reservationService.getReservationById(reservationId)
                    .orElseThrow(() -> new RuntimeException("Reservation not found"));

            // Update the status
            reservation.setStatus(newStatus);

            reservationService.saveReservation(reservation);

            return ResponseEntity.ok(reservation);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/class/date/{reservationDate}")
    public ResponseEntity<List<ReservationClassResponse>> getReservationsByDate(@PathVariable String reservationDate) {
        try {
            // Fetch reservations for the given date
            List<ReservationClassResponse> reservations = reservationService.getReservationsByDate(reservationDate);
            return ResponseEntity.ok(reservations);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

