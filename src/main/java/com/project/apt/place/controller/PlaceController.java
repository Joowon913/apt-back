package com.project.apt.place.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apt.common.Message;
import com.project.apt.place.dto.PlaceDto;
import com.project.apt.place.service.PlaceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "근무지 API")
@RequestMapping("/api/apt/v1")
@RestController
@RequiredArgsConstructor
public class PlaceController {
	private final PlaceService placeService;
	
	@Operation(summary = "근무지 목록 조회", description = "근무지 목록을 조회한다.")
	@GetMapping("/place")
	public ResponseEntity<Message<List<PlaceDto>>> place() {
		List<PlaceDto> dataList = placeService.getPlaceAll();
		Message<List<PlaceDto>> returnData = new Message<>("조회 성공", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "근무지 정보 등록", description = "근무지 정보를 등록한다.")
	@PostMapping("/place")
	public ResponseEntity<Message> createPlace(@RequestBody PlaceDto placeDto) {
		PlaceDto result = placeService.createPlace(placeDto);
		Message returnData = new Message<>("저장 성공", result);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "근무지 정보 수정", description = "근무지 정보를 수정한다.")
	@PutMapping("/place")
	public ResponseEntity<Message> editPlace(@RequestBody PlaceDto placeDto) {
		PlaceDto editData = placeService.updatePlace(placeDto);
		Message returnData = new Message("수정 성공", editData);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "근무지 정보 삭제", description = "근무지 정보를 삭제한다.")
	@DeleteMapping("/place")
	public ResponseEntity<Message> deletePlace(@RequestBody List<Long> idList) {
		boolean result = placeService.deletePlaceList(idList);
		Message returnData = new Message(Boolean.toString(result));
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
