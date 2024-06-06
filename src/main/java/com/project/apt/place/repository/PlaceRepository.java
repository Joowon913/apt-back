package com.project.apt.place.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apt.place.entity.Place;

public interface PlaceRepository extends JpaRepository<Place, Long>{
	public List<Place> findAll();
}
