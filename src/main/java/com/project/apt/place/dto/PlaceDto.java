package com.project.apt.place.dto;

import com.project.apt.place.entity.Place;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "근무지 DTO")
public class PlaceDto {

	@Schema(description = "근무지 ID(수정 시 사용)", example = "1")
	private Long placeId;
	@Schema(description = "근무지명", example = "더샾파크프레스티지")
	private String workPlace;
	@Schema(description = "근무지 주소", example = "서울특별시 영등포구 가마산로 79길 37")
	private String address;
	
	public Place toEntity() {
		return Place.builder()
				.placeId(placeId)
				.workPlace(workPlace)
				.address(address)
				.build();
	}
}
