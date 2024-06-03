package com.project.apt.emp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.apt.emp.dto.EmpDto;
import com.project.apt.emp.entity.Emp;
import com.project.apt.emp.repository.EmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpService {
	private final EmpRepository empRepository;
	
	public List<EmpDto> getEmpAll() {
		List<Emp> empList = empRepository.findAll();
		List<EmpDto> empDtoList = empList.stream().map(Emp::toDto).collect(Collectors.toList());
		return empDtoList;
	}
}
