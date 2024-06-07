package com.project.apt.place.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.apt.place.dto.PlaceDto;
import com.project.apt.place.entity.Place;
import com.project.apt.place.repository.PlaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceService {
	private final PlaceRepository placeRepository;
	
	public List<PlaceDto> getPlaceAll() {
		List<Place> placeList = placeRepository.findAll();
		List<PlaceDto> placeDtoList = placeList.stream().map(Place::toDto).collect(Collectors.toList());
		return placeDtoList;
	}
	
	public PlaceDto createPlace(PlaceDto placeDto) {
		Place place = placeDto.toEntity();
		Place savePlace = placeRepository.save(place);
		
		return savePlace.toDto();
	}
}
