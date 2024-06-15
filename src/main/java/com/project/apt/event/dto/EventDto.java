package com.project.apt.event.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.project.apt.event.entity.Event;

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
@Schema(description = "이달의 행사 정보 DTO")
public class EventDto {
	
	@Schema(description = "이달의행사ID(수정 시 사용)", example = "1")
	private Long eventId;
	
	@Schema(description = "근무지ID", example = "1")
	private Long empId;
	
	@Schema(description = "날짜/시간", example = "2022.05.30 17:00")
	private LocalDateTime dateTime;
	
	@Schema(description = "제목", example = "야간 장터")
	private String title;
	
	@Schema(description = "제목", example = "행사 상세 내용...")
	private String content;
	
	@Schema(description = "비고", example = "")
	private String note;
	
	@Schema(description = "근무자 이름", example = "홍길동")
	private String name;
	
	@Schema(description = "등록일", example = "2024-05-30")
	private Date insertDate;

	@Schema(description = "수정일", example = "null")
	private Date updateDate;
	
	public Event toEntity() {
		return Event.builder()
			.eventId(eventId)
			.empId(empId)
			.dateTime(dateTime)
			.title(title)
			.content(content)
			.note(note)
			.name(name)
			.insertDate(insertDate)
			.updateDate(updateDate)
			.build();
	}
}
