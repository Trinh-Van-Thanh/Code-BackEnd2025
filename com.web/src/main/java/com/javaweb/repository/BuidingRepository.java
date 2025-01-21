package com.javaweb.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.repository.entity.BuiDingEntity;

public interface BuidingRepository {
	List<BuiDingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
	void DeleteById(Long id);
}
