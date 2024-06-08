package com.project.apt.emp.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apt.common.Message;
import com.project.apt.emp.dto.EmpDto;
import com.project.apt.emp.service.EmpService;

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
}
