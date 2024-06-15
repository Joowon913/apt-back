package com.project.apt.event.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apt.common.Message;
import com.project.apt.event.dto.EventDto;
import com.project.apt.event.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "이달의 행사 API")
@RequestMapping("/api/apt/v1")
@RestController
@RequiredArgsConstructor
public class EventController {
	private final EventService eventService;
	
	@Operation(summary = "이달의 행사 목록 조회", description = "이달의 행사 목록을 조회한다.")
	@GetMapping("/event")
	public ResponseEntity<Message<List<EventDto>>> emp() {
		List<EventDto> dataList = eventService.getEventAll();
		Message<List<EventDto>> returnData = new Message<>("", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "이달의 행사 정보 등록", description = "이달의 행사 정보를 등록한다.")
	@PostMapping("/event")
	public ResponseEntity<Message> createPlace(@RequestBody EventDto eventDto) {
		EventDto result = eventService.createEmp(eventDto);
		Message returnData = new Message<>("저장 성공", result);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
