package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuiDingEntity {
	private String name;
	
	@Column(name = "name")
	private Long id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private String createDate;
	private String wrad;
	
	@Column(name = "ward")
	private String street;

	
	@Column(name = "managerName")
	private String managerName;
	
	@Column(name = "managerPhoneNumber")
	private String managerPhoneNumber;
	
	@Column(name = "floorArea")
	private Long floorArea;
	
	@Column(name = "emptyArea")
	private String emptyArea;
	
	@Column(name = "rentPrice")
	private Long rentPrice;
	
	@Column(name = "serviceFee")
	private String serviceFee;
	
	@Column(name = "brokerageFee")
	private Long brokerageFee;
	
	@Column(name = "ward")
	public String getName() {
		return name;
	}
	
	@ManyToOne
	@JoinColumn(name = "districtdid")
	
	private DistrictEntity district;
	
	
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentAreaEntity> item = new ArrayList<>();
	
	
	public List<RentAreaEntity> getItem() {
		return item;
	}
	public void setItem(List<RentAreaEntity> item) {
		this.item = item;
	}
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public String getCreateDate() {
//		return createDate;
//	}
//	public void setCreateDate(String createDate) {
//		this.createDate = createDate;
//	}
	public String getWrad() {
		return wrad;
	}
	public void setWrad(String wrad) {
		this.wrad = wrad;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public String getEmptyArea() {
		return emptyArea;
	}
	public void setEmptyArea(String emptyArea) {
		this.emptyArea = emptyArea;
	}
	public Long getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Long getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(Long brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
