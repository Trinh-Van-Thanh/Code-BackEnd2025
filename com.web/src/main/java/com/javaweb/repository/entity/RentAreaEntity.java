package com.javaweb.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
	
	private Long id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String value;
	
	
	@Column(name = "value")
	
	@ManyToOne()
	@JoinColumn(name = "buildingid")
	
	private BuiDingEntity buiding;
	
	
	
	public BuiDingEntity getBuiding() {
		return buiding;
	}

	public void setBuiding(BuiDingEntity buiding) {
		this.buiding = buiding;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
