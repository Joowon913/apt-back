package com.project.apt.event.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import com.project.apt.event.dto.EventDto;

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
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private Long eventId;
	
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	
	private String title;
	private String content;
	private String note;
	private String name;
	
	@Column(name = "insert_date")
	private Date insertDate;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	public EventDto toDto() {
		return EventDto.builder()
			.eventId(this.eventId)
			.empId(this.empId)
			.dateTime(this.dateTime)
			.title(this.title)
			.content(this.content)
			.note(this.note)
			.name(this.name)
			.insertDate(this.insertDate)
			.updateDate(this.updateDate)
			.build();
	}
}
