package com.project.apt.lostitem.controller;

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
import com.project.apt.lostitem.dto.LostItemDto;
import com.project.apt.lostitem.service.LostItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "분실물 API")
@RequestMapping("/api/apt/v1")
@RestController
@RequiredArgsConstructor
public class LostItemController {
	private final LostItemService lostItemService;
	
	@Operation(summary = "분실물 목록 조회", description = "분실물 목록을 조회한다.")
	@GetMapping("/lost")
	public ResponseEntity<Message<List<LostItemDto>>> lostItem() {
		List<LostItemDto> dataList = lostItemService.getLostItemAll();
		Message<List<LostItemDto>> returnData = new Message<>("", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
	
	@Operation(summary = "분실물 정보 등록", description = "분실물 정보를 등록한다.")
	@PostMapping("/lost")
	public ResponseEntity<Message> createLostItem(@RequestBody LostItemDto lostItemDto) {
		LostItemDto result = lostItemService.createLostItem(lostItemDto);
		Message returnData = new Message<>("저장 성공", result);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
