package com.example.CMS.Controller;


import com.example.CMS.DTO.eventRequest;
import com.example.CMS.Entity.Event;
import com.example.CMS.Service.eventService;
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
    private eventService eventService;

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody eventRequest request) {
        Event event=eventService.addEvent(request);
        return ResponseEntity.ok(event);
    }
}
