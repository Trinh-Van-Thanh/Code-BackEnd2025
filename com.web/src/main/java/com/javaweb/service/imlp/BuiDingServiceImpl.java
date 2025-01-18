package com.javaweb.service.imlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.converter.BuiDingDTOConverter;
import com.javaweb.repository.BuidingRepository;
import com.javaweb.repository.DistricReponsitory;
import com.javaweb.repository.RentAreaReponsitory;
import com.javaweb.repository.entity.BuiDingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.service.BuidingServicer;

import Model.BuiDingDTO;

@Service
public class BuiDingServiceImpl implements BuidingServicer {
	@Autowired
	private BuidingRepository buidingRepository;
	
	@Autowired
	private BuiDingDTOConverter buidingconverter;
	@Override
	public List<BuiDingDTO> findAll(Map<String,Object> params,List<String> typeCode) {
		List<BuiDingEntity> buiDtos = buidingRepository.findAll( params,typeCode);
		List<BuiDingDTO> result = new ArrayList<BuiDingDTO>();
		for (BuiDingEntity item : buiDtos) {
			BuiDingDTO buiding = buidingconverter.toBuiDingDTO(item);	
			result.add(buiding);
		}
		return result;
	}

}
