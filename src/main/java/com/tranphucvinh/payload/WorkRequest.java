package com.tranphucvinh.payload;

import java.util.Date;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkRequest {

	private Long id;

	@NotBlank
	@Size(min = 5, max = 100)
	private String work_name;
	
	@NotBlank
	@Size(min = 10, max = 500)
	private String description;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date start_date;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date end_date;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
}