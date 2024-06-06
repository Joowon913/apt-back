package com.project.apt.place.entity;


import com.project.apt.place.dto.PlaceDto;

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
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_id")
	private Long placeId;
	
	@Column(name = "work_place")
	private String workPlace;
	private String address;
	
	public PlaceDto toDto() {
		return PlaceDto.builder()
				.placeId(this.placeId)
				.workPlace(this.workPlace)
				.address(this.address)
				.build();
	}
}
