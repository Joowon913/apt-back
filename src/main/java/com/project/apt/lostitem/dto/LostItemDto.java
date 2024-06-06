package com.project.apt.lostitem.dto;

import java.sql.Date;

import com.project.apt.lostitem.entity.LostItem;

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
public class LostItemDto {
	private Long lostItemId;
	private Long empId;
	private String title;
	private String content;
	private String note;
	private String status;
	private String name;
	private Date insertDate;
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
