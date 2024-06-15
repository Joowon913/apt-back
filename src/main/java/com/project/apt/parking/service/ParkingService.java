package com.project.apt.parking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.apt.parking.dto.ParkingDto;
import com.project.apt.parking.entity.Parking;
import com.project.apt.parking.repository.ParkingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkingService {
	private final ParkingRepository parkingRepository;
	
	public List<ParkingDto> getParkingAll() {
		List<Parking> parkingList = parkingRepository.findAll();
		List<ParkingDto> parkingDtoList = parkingList.stream().map(Parking::toDto).collect(Collectors.toList());
		return parkingDtoList;
	}
	
	public ParkingDto createParking(ParkingDto parkingDto) {
		Parking parking = parkingDto.toEntity();
		Parking saveParking = parkingRepository.save(parking);
		return saveParking.toDto();
	}
}
