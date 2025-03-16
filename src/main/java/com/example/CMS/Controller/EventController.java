package com.example.CMS.Controller;

import com.example.CMS.DTO.EventRequest;
import com.example.CMS.Entity.Course;
import com.example.CMS.Entity.Event;
import com.example.CMS.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody EventRequest request) {
        Event event = eventService.addEvent(request);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public List<Event> getAllEvent(){
        return  eventService.getAllEvents();
    }

}
