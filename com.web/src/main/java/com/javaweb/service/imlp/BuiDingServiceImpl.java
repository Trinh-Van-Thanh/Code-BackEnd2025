package com.javaweb.service.imlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.repository.BuidingRepository;
import com.javaweb.repository.entity.BuiDingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.impl.DistricReponsitory;
import com.javaweb.service.BuidingServicer;

import Model.BuiDingDTO;

@Service
public class BuiDingServiceImpl implements BuidingServicer {
	@Autowired
	private BuidingRepository buidingRepository;
	@Autowired 
	private DistricReponsitory districReponsitory;
	@Override
	public List<BuiDingDTO> findAll(Map<String,Object> params,List<String> typeCode) {
		List<BuiDingEntity> buiDtos = buidingRepository.findAll( params,typeCode);
		List<BuiDingDTO> result = new ArrayList<BuiDingDTO>();
		for (BuiDingEntity item : buiDtos) {
			BuiDingDTO buiding = new BuiDingDTO();
			buiding.setName(item.getName());
			
			Long districtId = Long.valueOf(item.getDistrictid());
			DistrictEntity districtEntity = districReponsitory.findNameById(districtId);

			//DistrictEntity districtEntity =districReponsitory.findNameById(item.getDistrictid());
			buiding.setAddress(item.getStreet() + "," + item.getWrad() + "," + districtEntity.getName());
			result.add(buiding);
		}
		return result;
	}

}
