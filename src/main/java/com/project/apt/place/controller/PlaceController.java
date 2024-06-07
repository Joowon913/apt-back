package com.project.apt.place.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.apt.common.Message;
import com.project.apt.place.dto.PlaceDto;
import com.project.apt.place.service.PlaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PlaceController {
	private final PlaceService placeService;
	
	@GetMapping("/api/apt/v1/place")
	public ResponseEntity<Message<List<PlaceDto>>> place() {
		List<PlaceDto> dataList = placeService.getPlaceAll();
		Message<List<PlaceDto>> returnData = new Message<>("조회 성공", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@PostMapping("/api/apt/v1/place")
	public ResponseEntity<Message> createPlace(@RequestBody PlaceDto placeDto) {
		PlaceDto result = placeService.createPlace(placeDto);
		Message returnData = new Message<>("저장 성공", result);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
