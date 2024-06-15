package com.project.apt.parking.entity;

import java.sql.Date;

import com.project.apt.parking.dto.ParkingDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parking_id")
	private Long parkingId;
	
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "car_number")
	private String carNumber;
	
	private String location;
	private String note;
	private String name;
	
	@Column(name = "insert_date")
	private Date insertDate;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	public ParkingDto toDto() {
		return ParkingDto.builder()
			.parkingId(this.parkingId)
			.empId(this.empId)
			.carNumber(this.carNumber)
			.location(this.location)
			.note(this.note)
			.name(this.name)
			.insertDate(this.insertDate)
			.updateDate(this.updateDate)
			.build();
	}
}
