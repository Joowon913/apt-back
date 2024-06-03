package com.project.apt.emp.dto;

import java.sql.Date;

import com.project.apt.emp.entity.Emp;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpDto {
	private Long empId;
	private Long placeId;
	private String id;
	private String password;
	private String department;
	private String position;
	private String auth;
	private String name;
	private String phone;
	private String address;
	private String addressDetail;
	private Date birth;
	
	public Emp toEntity() {
		return Emp.builder()
				.empId(empId)
				.placeId(placeId)
				.id(id)
				.password(password)
				.department(department)
				.position(position)
				.auth(auth)
				.name(name)
				.phone(phone)
				.address(address)
				.addressDetail(addressDetail)
				.birth(birth)
				.build();
	}
}
