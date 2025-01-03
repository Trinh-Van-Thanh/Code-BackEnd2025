package com.javaweb.repository;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.repository.entity.BuiDingEntity;

public interface BuidingRepository {
	List<BuiDingEntity> findAll(String name,Long districtId);
	void DeleteById(Long id);
}
