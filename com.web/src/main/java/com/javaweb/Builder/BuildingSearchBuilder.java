package com.javaweb.Builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name;
	private Long floorArea;
	private String ward;
	private String street;
	private String districtCode;
	private Integer numberOfBasement;
	private List<String> typeCode = new ArrayList<String>();
	private String managerName;
	private String managerPhoneNumber;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private Long areaFrom;
	private Long areaTo;
	private Long staffId;

	
	
	public BuildingSearchBuilder(Buider buider) {
		this.name = buider.name;
		this.floorArea = buider.floorArea;
		this.ward = buider.ward;
		this.street = buider.street;
		this.districtCode = buider.districtCode;
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

	public String getDistrictCode() {
		return districtCode;
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
		private String districtCode;
		private Integer numberOfBasement;
		private List<String> typeCode = new ArrayList<String>();
		private String managerName;
		private String managerPhoneNumber;
		private Long rentPriceFrom;
		private Long rentPriceTo;
		private Long areaFrom;
		private Long areaTo;
		private Long staffId;

		public void setName(String name) {
			this.name = name;
		}

		public void setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
		}

		public void setWard(String ward) {
			this.ward = ward;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public void setDistrictCode(String districtCode) {
			this.districtCode = districtCode;
		}

		public void setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
		}

		public void setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
		}

		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}

		public void setManagerPhoneNumber(String managerPhoneNumber) {
			this.managerPhoneNumber = managerPhoneNumber;
		}

		public void setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
		}

		public void setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
		}

		public void setAreaFrom(Long areaFrom) {
			this.areaFrom = areaFrom;
		}

		public void setAreaTo(Long areaTo) {
			this.areaTo = areaTo;
		}

		public void setStaffId(Long staffId) {
			this.staffId = staffId;
		}
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}

	}
}
