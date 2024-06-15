package com.project.apt.parking.dto;

import java.sql.Date;

import com.project.apt.parking.entity.Parking;

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
@Schema(description = "주차 정보 DTO")
public class ParkingDto {
	@Schema(description = "주차ID(수정 시 사용)", example = "1")
	private Long parkingId;

	@Schema(description = "근무자ID", example = "1")
	private Long empId;
	
	@Schema(description = "차량 번호", example = "99어 9999")
	private String carNumber;
	
	@Schema(description = "주차 위치", example = "1")
	private String location;
	
	@Schema(description = "비고", example = "")
	private String note;
	
	@Schema(description = "근무자 이름", example = "홍길동")
	private String name;
	
	@Schema(description = "등록일", example = "2024-05-30")
	private Date insertDate;

	@Schema(description = "수정일", example = "null")
	private Date updateDate;
	
	public Parking toEntity() {
		return Parking.builder()
				.parkingId(parkingId)
				.empId(empId)
				.carNumber(carNumber)
				.location(location)
				.note(note)
				.name(name)
				.insertDate(insertDate)
				.updateDate(updateDate)
				.build();
	}
}
