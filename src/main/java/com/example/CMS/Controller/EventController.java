package com.example.CMS.Controller;


import com.example.CMS.DTO.EventRequest;
import com.example.CMS.Entity.Event;
import com.example.CMS.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody EventRequest request) {
        Event event=eventService.addEvent(request);
        return ResponseEntity.ok(event);
    }
}
