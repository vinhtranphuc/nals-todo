package com.tranphucvinh.mybatis.entity;

public class Work {
	public String work_id;
	public String work_name;
	public String description;
	private User user;
	public String start_date;
	public String end_date;
	public String status;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
