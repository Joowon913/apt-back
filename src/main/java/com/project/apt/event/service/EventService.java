package com.project.apt.event.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.apt.event.dto.EventDto;
import com.project.apt.event.entity.Event;
import com.project.apt.event.repository.EventRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {
	private final EventRepository eventRepository;
	
	public List<EventDto> getEventAll() {
		List<Event> eventList = eventRepository.findAll();
		List<EventDto> eventDtoList = eventList.stream().map(Event::toDto).collect(Collectors.toList());
		return eventDtoList;
	}
}
