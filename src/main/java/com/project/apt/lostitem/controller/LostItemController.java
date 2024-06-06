package com.project.apt.lostitem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apt.common.Message;
import com.project.apt.lostitem.dto.LostItemDto;
import com.project.apt.lostitem.service.LostItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LostItemController {
	private final LostItemService lostItemService;
	
	@GetMapping("/api/apt/v1/lost")
	public ResponseEntity<Message<List<LostItemDto>>> lostItem() {
		List<LostItemDto> dataList = lostItemService.getLostItemAll();
		Message<List<LostItemDto>> returnData = new Message<>("", dataList);
		return new ResponseEntity<>(returnData, HttpStatus.OK);
	}
}
