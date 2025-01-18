package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.RentAreaEntity;

public interface RentAreaReponsitory {
	List<RentAreaEntity> getvalueByBuiDingId(Long id);
}
