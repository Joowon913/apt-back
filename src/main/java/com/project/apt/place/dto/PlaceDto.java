package com.project.apt.place.dto;

import com.project.apt.place.entity.Place;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceDto {
	private Long placeId;
	private String workPlace;
	private String address;
	
	public Place toEntity() {
		return Place.builder()
				.placeId(placeId)
				.workPlace(workPlace)
				.address(address)
				.build();
	}
}
