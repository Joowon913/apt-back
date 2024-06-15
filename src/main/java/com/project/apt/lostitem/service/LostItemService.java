package com.project.apt.lostitem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.apt.lostitem.entity.LostItem;
import com.project.apt.lostitem.dto.LostItemDto;
import com.project.apt.lostitem.repository.LostItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LostItemService {
	private final LostItemRepository lostItemRepository;
	
	public List<LostItemDto> getLostItemAll() {
		List<LostItem> lostItemList = lostItemRepository.findAll();
		List<LostItemDto> lostItemDtoList = lostItemList.stream().map(LostItem::toDto).collect(Collectors.toList());
		return lostItemDtoList;
	}
	
	public LostItemDto createLostItem(LostItemDto lostItemDto) {
		LostItem lostItem = lostItemDto.toEntity();
		LostItem saveLostItem = lostItemRepository.save(lostItem);
		return saveLostItem.toDto();
	}
}
