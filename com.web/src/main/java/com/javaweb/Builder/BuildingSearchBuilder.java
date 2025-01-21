package com.javaweb.Builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name;
	private Long floorArea;
	private String ward;
	private String street;
	private Long districtId;
	private Integer numberOfBasement;
	private List<String> typeCode = new ArrayList<String>();
	private String managerName;
	private String managerPhoneNumber;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private Long areaFrom;
	private Long areaTo;
	private Long staffId;

	private BuildingSearchBuilder(Buider buider) {
		this.name = buider.name;
		this.floorArea = buider.floorArea;
		this.ward = buider.ward;
		this.street = buider.street;
		this.districtId = buider.districtId;
		this.numberOfBasement = buider.numberOfBasement;
		this.typeCode = buider.typeCode;
		this.managerName = buider.managerName;
		this.managerPhoneNumber = buider.managerPhoneNumber;
		this.rentPriceFrom = buider.rentPriceFrom;
		this.rentPriceTo = buider.rentPriceTo;
		this.areaFrom = buider.areaFrom;
		this.areaTo = buider.areaTo;
		this.staffId = buider.staffId;
	}

	public String getName() {
		return name;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public List<String> getTypeCode() {
		return typeCode;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}

	public Long getRentPriceTo() {
		return rentPriceTo;
	}

	public Long getAreaFrom() {
		return areaFrom;
	}

	public Long getAreaTo() {
		return areaTo;
	}

	public Long getStaffId() {
		return staffId;
	}

	public static class Buider {

		private String name;
		private Long floorArea;
		private String ward;
		private String street;
		private Long districtId;
		private Integer numberOfBasement;
		private List<String> typeCode = new ArrayList<String>();
		private String managerName;
		private String managerPhoneNumber;
		private Long rentPriceFrom;
		private Long rentPriceTo;
		private Long areaFrom;
		private Long areaTo;
		private Long staffId;

		public Buider setName(String name) {
			this.name = name;
			return this;
		}

		public Buider setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
			return this;
		}

		public Buider setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Buider setStreet(String street) {
			this.street = street;
			return this;
		}

		public Buider setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}

		public Buider setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Buider setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}

		public Buider setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}

		public Buider setManagerPhoneNumber(String managerPhoneNumber) {
			this.managerPhoneNumber = managerPhoneNumber;
			return this;
		}

		public Buider setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}

		public Buider setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}

		public Buider setAreaFrom(Long areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}

		public Buider setAreaTo(Long areaTo) {
			this.areaTo = areaTo;
			return this;
		}

		public Buider setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}

	}
}
