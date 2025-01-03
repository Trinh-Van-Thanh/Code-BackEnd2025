package com.javaweb.service.imlp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.repository.BuidingRepository;
import com.javaweb.repository.entity.BuiDingEntity;
import com.javaweb.service.BuidingServicer;

import Model.BuiDingDTO;

@Service
public class BuiDingServiceImpl implements BuidingServicer {
	@Autowired
	private BuidingRepository buidingRepository;
	@Override
	public List<BuiDingDTO> findAll(String name, Long districtId) {
		// TODO Auto-generated method stub
		List<BuiDingEntity> buiDtos = buidingRepository.findAll(name,districtId);
		List<BuiDingDTO> result = new ArrayList<BuiDingDTO>();
		for (BuiDingEntity item : buiDtos) {
			BuiDingDTO buiding = new BuiDingDTO();
			buiding.setName(item.getName());
			buiding.setAddress(item.getSterrt() + "," + item.getWard());
			buiding.setNumberOfBasement(item.getNumberOfBasement());
			result.add(buiding);
		}
		return result;
	}

}
