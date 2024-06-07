package com.project.apt.event.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apt.common.Message;
import com.project.apt.event.dto.EventDto;
import com.project.apt.event.service.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EventController {
	private final EventService eventService;
	
	@GetMapping("/api/apt/v1/event")
	public ResponseEntity<Message<List<EventDto>>> emp() {
		List<EventDto> dataList = eventService.getEventAll();
		Message<List<EventDto>> returnData = new Message<>("", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
