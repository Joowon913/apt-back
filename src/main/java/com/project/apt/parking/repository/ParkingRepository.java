package com.project.apt.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apt.parking.entity.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long>{
	public List<Parking> findAll();
}
