package com.javaweb.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javaweb.repository.entity.BuiDingEntity;

public interface BuidingRepository {
	List<BuiDingEntity> findAll(Map<String,Object> params,List<String> typeCode);
	void DeleteById(Long id);
}
