package com.project.apt.lostitem.dto;

import java.sql.Date;

import com.project.apt.lostitem.entity.LostItem;

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
@Schema(description = "분실물 정보 DTO")
public class LostItemDto {
	@Schema(description = "분실물ID(수정 시 사용)", example = "1")
	private Long lostItemId;
	
	@Schema(description = "근무자ID", example = "1")
	private Long empId;
	
	@Schema(description = "제목", example = "잃어버린 가방을 보관하고 있습니다.")
	private String title;
	
	@Schema(description = "내용", example = "잃어버린 가방을 보관하고 있습니다. 관리과 와서 찾아가시면 됩니다.")
	private String content;
	
	@Schema(description = "비고", example = "")
	private String note;
	
	@Schema(description = "상태", example = "분실")
	private String status;
	
	@Schema(description = "근무자 이름", example = "홍길동")
	private String name;
	
	@Schema(description = "등록일", example = "2024-05-30")
	private Date insertDate;
	
	@Schema(description = "수정일", example = "null")
	private Date updateDate;
	
	public LostItem toEntity() {
		return LostItem.builder()
				.lostItemId(lostItemId)
				.empId(empId)
				.title(title)
				.content(content)
				.note(note)
				.status(status)
				.name(name)
				.insertDate(insertDate)
				.updateDate(updateDate)
				.build();
	}
}
