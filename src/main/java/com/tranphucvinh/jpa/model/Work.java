package com.tranphucvinh.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.tranphucvinh.jpa.model.audit.UserDateAudit;

@SuppressWarnings("serial")
@Entity
@Table(name = "works")
public class Work extends UserDateAudit{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "work_id")
	private long id;
	
	@Size( max = 100)
	private String work_name;
	
	@Size(max = 500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private Date start_date;

	private Date end_date;
	
	public Work() {
		
	}
	public Work(String work_name, String description, Date start_date, Date end_date) {
		this.work_name = work_name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public Work(Long id,String work_name, String description, Date start_date, Date end_date) {
		this.id = id;
		this.work_name = work_name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}