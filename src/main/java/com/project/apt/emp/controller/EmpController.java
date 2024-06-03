package com.project.apt.emp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apt.common.Message;
import com.project.apt.emp.dto.EmpDto;
import com.project.apt.emp.service.EmpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmpController {
	private final EmpService empService;
	
	@GetMapping("/api/apt/v1/emp")
	public ResponseEntity<Message<List<EmpDto>>> emp() {
		List<EmpDto> dataList = empService.getEmpAll();
		Message<List<EmpDto>> returnData = new Message<>("", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
