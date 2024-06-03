package com.project.apt.emp.entity;

import java.sql.Date;

import com.project.apt.emp.dto.EmpDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "place_id")
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth")
	private java.sql.Date birth;
	
	public EmpDto toDto() {
		return EmpDto.builder()
				.empId(this.empId)
				.placeId(this.placeId)
				.id(this.id)
				.password(this.password)
				.department(this.department)
				.position(this.position)
				.auth(this.auth)
				.name(this.name)
				.phone(this.phone)
				.address(this.address)
				.addressDetail(this.addressDetail)
				.birth(this.birth)
				.build();
	}
}
