package com.project.apt.emp.service;

import java.util.List;
import java.util.Optional;
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
	
	public EmpDto createEmp(EmpDto empDto) {
		Emp emp = empDto.toEntity();
		Emp saveEmp = empRepository.save(emp);
		return saveEmp.toDto();
	}
	
	public EmpDto updateEmp(EmpDto empDto) {
		Emp emp = empDto.toEntity();
		
		Optional<Emp> existEmp = empRepository.findById(emp.getEmpId());
		
		if(existEmp.isPresent()) {
			Emp updateEmp = empRepository.save(emp);
			return updateEmp.toDto();
		} else {
			return null;
		}
	}
	
	public boolean deleteEmpList(List<Long> idList) {
		int deletedCount = empRepository.deleteAllByEmpIdIn(idList);
		if(deletedCount > 0 && deletedCount == idList.size()) {
			return true;
		} else {
			return false;
		}
	}
}
