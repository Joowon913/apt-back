package com.project.apt.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apt.event.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
	public List<Event> findAll();
}
