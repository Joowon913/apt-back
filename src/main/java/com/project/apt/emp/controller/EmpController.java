package com.project.apt.emp.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import com.project.apt.emp.dto.EmpDto;
import com.project.apt.emp.service.EmpService;
import com.project.apt.place.dto.PlaceDto;

import lombok.RequiredArgsConstructor;

@Tag(name = "근무자 API")
@RequestMapping("/api/apt/v1")
@RestController
@RequiredArgsConstructor
public class EmpController {
	private final EmpService empService;

	@Operation(summary = "근무자 목록 조회", description = "근무자 목록을 조회한다.")
	@GetMapping("/emp")
	public ResponseEntity<Message<List<EmpDto>>> emp() {
		List<EmpDto> dataList = empService.getEmpAll();
		Message<List<EmpDto>> returnData = new Message<>("", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "근무자 정보 등록", description = "근무자 정보를 등록한다.")
	@PostMapping("/emp")
	public ResponseEntity<Message> createPlace(@RequestBody EmpDto empDto) {
		EmpDto result = empService.createEmp(empDto);
		Message returnData = new Message<>("저장 성공", result);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "근무자 정보 수정", description = "근무자 정보를 수정한다.")
	@PutMapping("/emp")
	public ResponseEntity<Message> editEmp(@RequestBody EmpDto empDto) {
		EmpDto editData = empService.updateEmp(empDto);
		Message returnData = new Message("수정 성공", editData);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "근무자 정보 삭제", description = "근무자 정보를 삭제한다.")
	@DeleteMapping("/emp")
	public ResponseEntity<Message> deleteEmp(@RequestBody List<Long> idList) {
		boolean result = empService.deleteEmpList(idList);
		Message returnData = new Message(Boolean.toString(result));
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
