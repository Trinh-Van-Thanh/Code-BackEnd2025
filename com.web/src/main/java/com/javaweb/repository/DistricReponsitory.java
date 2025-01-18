package com.javaweb.repository;

import com.javaweb.repository.entity.DistrictEntity;

public interface DistricReponsitory {
	DistrictEntity findNameById(Long id);
}
