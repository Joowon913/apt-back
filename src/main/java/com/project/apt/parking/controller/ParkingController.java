package com.project.apt.parking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apt.common.Message;
import com.project.apt.parking.dto.ParkingDto;
import com.project.apt.parking.service.ParkingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "주차 관리 API")
@RequestMapping("/api/apt/v1")
@RestController
@RequiredArgsConstructor
public class ParkingController {
	private final ParkingService parkingService;
	
	@Operation(summary = "주차 관리 목록 조회", description = "주차 관리 목록을 조회한다.")
	@GetMapping("/parking")
	public ResponseEntity<Message<List<ParkingDto>>> parking() {
		List<ParkingDto> dataList = parkingService.getParkingAll();
		Message<List<ParkingDto>> returnData = new Message<>("", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "주차 관리 정보 등록", description = "주차 관리 정보를 등록한다.")
	@PostMapping("/parking")
	public ResponseEntity<Message> createPlace(@RequestBody ParkingDto parkingDto) {
		ParkingDto result = parkingService.createParking(parkingDto);
		Message returnData = new Message<>("저장 성공", result);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
