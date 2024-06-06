package com.project.apt.lostitem.entity;

import java.sql.Date;

import com.project.apt.lostitem.dto.LostItemDto;


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
public class LostItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lostitem_id")
	private Long lostItemId;
	
	@Column(name = "emp_id")
	private Long empId;
	private String title;
	private String content;
	private String note;
	private String status;
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "insert_date")
	private Date insertDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	private Date updateDate;
	
	public LostItemDto toDto() {
		return LostItemDto.builder()
				.lostItemId(this.lostItemId)
				.empId(this.empId)
				.title(this.title)
				.content(this.content)
				.note(this.note)
				.status(this.status)
				.name(this.name)
				.insertDate(this.insertDate)
				.updateDate(this.updateDate)
				.build();
	}
}
