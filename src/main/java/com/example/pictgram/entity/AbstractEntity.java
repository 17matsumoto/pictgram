package com.example.pictgram.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity {

	
	@Column(name="created_at")
	private Date createDate;
	
	@Column(name = "update_at")
	private Date  updatedAt;
	
	@PrePersist
	public void onPrePersist() {
		Date date  = new Date();
		setCreateDate(date);
		setUpdatedAt(date);
		
		
	}
	
	@PreUpdate
	public void onPreUpdate() {
		setUpdatedAt(new Date());
	}
	
	
}
