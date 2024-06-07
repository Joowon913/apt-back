package com.project.apt.event.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.project.apt.event.entity.Event;

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
public class EventDto {
	private Long eventId;
	private Long empId;
	private LocalDateTime dateTime;
	private String title;
	private String content;
	private String note;
	private String name;
	private Date insertDate;
	private Date updateDate;
	
	public Event toDto() {
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
