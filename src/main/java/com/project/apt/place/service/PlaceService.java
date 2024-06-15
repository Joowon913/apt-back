package com.project.apt.place.service;

import java.util.List;
import java.util.Optional;
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
	
	public PlaceDto updatePlace(PlaceDto placeDto) {
		Place place = placeDto.toEntity();
		
		Optional<Place> existPlace = placeRepository.findById(place.getPlaceId());
		
		if(existPlace.isPresent()) {
			Place updatePlace = placeRepository.save(place);
			return updatePlace.toDto();
		} else {
			return null;
		}
	}
	
	public boolean deletePlaceList(List<Long> idList) {
		int deletedCount = placeRepository.deleteAllByPlaceIdIn(idList);
		if(deletedCount > 0 && deletedCount == idList.size()) {
			return true;
		} else {
			return false;
		}
	}
}
