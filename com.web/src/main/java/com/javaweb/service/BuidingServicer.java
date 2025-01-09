package com.javaweb.service;

import java.util.List;
import java.util.Map;

import Model.BuiDingDTO;

public interface BuidingServicer {
	List<BuiDingDTO> findAll(Map<String,Object> params,List<String> typeCode);
}
