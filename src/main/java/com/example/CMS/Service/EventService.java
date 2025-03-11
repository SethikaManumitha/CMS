package com.example.CMS.Service;

import com.example.CMS.DTO.EventRequest;
import com.example.CMS.Entity.Class;
import com.example.CMS.Entity.Event;
import com.example.CMS.Repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepository;

    public Event addEvent(EventRequest request){
        Event event=new Event();
        event.setName(request.getName());
        event.setDescription(request.getDescription());
        event.setDate(request.getDate());
        event.setStartTime(request.getStartTime());
        event.setEndTime(request.getEndTime());
        event.setEventType(request.getEventType());
        event.setOrganizer(request.getOrganizer());
        event.setMaxCapacity(request.getMaxCapacity());
        event.setRegisterDeadline(request.getRegisterDeadline());
        event.setStatus(request.getStatus());
        return eventRepository.save(event);
    }

    public Optional<Event> getEventById(int id) {
        return eventRepository.findById(id);
    }
}
