package com.example.CMS.Service;

import com.example.CMS.DTO.eventRequest;
import com.example.CMS.Entity.Event;
import com.example.CMS.Repository.eventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class eventService {
    @Autowired
    private eventRepo eventRepository;

    public Event addEvent(eventRequest request){
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
}
