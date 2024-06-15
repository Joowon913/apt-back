package com.project.apt.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apt.emp.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long> {
	public List<Emp> findAll();
	
	public int deleteAllByEmpIdIn(List<Long> idList);
}
