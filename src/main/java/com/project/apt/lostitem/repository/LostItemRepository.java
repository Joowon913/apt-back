package com.project.apt.lostitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apt.lostitem.entity.LostItem;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {
	public List<LostItem> findAll();
	
}
