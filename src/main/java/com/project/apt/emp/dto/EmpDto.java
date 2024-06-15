package com.project.apt.emp.dto;

import java.sql.Date;

import com.project.apt.emp.entity.Emp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "근무자 정보 DTO")
public class EmpDto {

	@Schema(description = "근무자ID(수정 시 사용)", example = "1")
	private Long empId;

	@Schema(description = "근무지ID", example = "1")
	private Long placeId;
	
	@Schema(description = "아이디", example = "test")
	private String id;
	
	@Schema(description = "비밀번호", example = "1111")
	private String password;
	
	@Schema(description = "부서", example = "관리과")
	private String department;
	
	@Schema(description = "직급", example = "사원")
	private String position;
	
	@Schema(description = "권한", example = "직원")
	private String auth;
	
	@Schema(description = "근무자 이름", example = "홍길동")
	private String name;
	
	@Schema(description = "번호", example = "010-0000-0000")
	private String phone;
	
	@Schema(description = "주소", example = "경기도 시흥시 금화로 645-1")
	private String address;
	
	@Schema(description = "상세 주소", example = "")
	private String addressDetail;
	
	@Schema(description = "생년월일", example = "1992-01-01")
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
