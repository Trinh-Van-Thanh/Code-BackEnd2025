package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.javaweb.repository.DistricReponsitory;
import com.javaweb.repository.RentAreaReponsitory;
import com.javaweb.repository.entity.BuiDingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;


import Model.BuiDingDTO;

@Component
public class BuiDingDTOConverter {
	@Autowired 
	private DistricReponsitory districReponsitory;
	
	@Autowired
	private RentAreaReponsitory rentAreaReponsitory;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BuiDingDTO toBuiDingDTO(BuiDingEntity item) {
		//BuiDingDTO buiding = new BuiDingDTO();
		BuiDingDTO buiding = modelMapper.map(item, BuiDingDTO.class);
//		buiding.setName(item.getName());(đã có modelMapper thì không cần set tay nữa bỏ hết và chỉ set những view k có)
		
		Long districtId = Long.valueOf(item.getDistrictid());
		DistrictEntity districtEntity = districReponsitory.findNameById(districtId);
		//DistrictEntity districtEntity =districReponsitory.findNameById(item.getDistrictid());
		buiding.setAddress(item.getStreet() + "," + item.getWrad() + "," + districtEntity.getName());
		List<RentAreaEntity> rentareas = rentAreaReponsitory.getvalueByBuiDingId(item.getId());
		String arensResult = rentareas.stream().map(it ->it.getValue().toString()).collect(Collectors.joining(","));
		buiding.setRentArea(arensResult);
		return buiding;
	}
}
