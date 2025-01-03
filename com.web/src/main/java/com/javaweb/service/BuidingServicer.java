package com.javaweb.service;

import java.util.List;

import Model.BuiDingDTO;

public interface BuidingServicer {
	List<BuiDingDTO> findAll(String name,Long districtId);
}
