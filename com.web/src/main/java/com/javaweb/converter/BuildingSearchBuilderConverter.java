package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.service.util.Maputil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String,Object> params,List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Buider()
																.setName(Maputil.getObjcet(params, "name", String.class))
																.setFloorArea(Maputil.getObjcet(params, "floorArea", Long.class))
																.setWard(Maputil.getObjcet(params, "ward", String.class))
																.setStreet(Maputil.getObjcet(params, "street", String.class))
																.setDistrictId(Maputil.getObjcet(params, "districtcode", Long.class))
																.setNumberOfBasement(Maputil.getObjcet(params, "numberofbasement", Integer.class))
																.setTypeCode(typeCode)
																.setManagerName(Maputil.getObjcet(params, "managername", String.class))
																.setManagerPhoneNumber(Maputil.getObjcet(params, "managerphonenumber", String.class))
																.setRentPriceTo(Maputil.getObjcet(params, "rentpriceto", Long.class))
																.setRentPriceFrom(Maputil.getObjcet(params, "rentpricefrom", Long.class))
																.setAreaTo(Maputil.getObjcet(params, "areato", Long.class))
																.setAreaFrom(Maputil.getObjcet(params, "areafrom", Long.class))
																.setStaffId(Maputil.getObjcet(params, "staffid", Long.class))
																.build();
																
																			
		return buildingSearchBuilder;
	}
}
