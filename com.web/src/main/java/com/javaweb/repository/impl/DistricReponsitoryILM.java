package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistricReponsitory;
import com.javaweb.repository.entity.BuiDingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.service.util.ConnectJDBCuitl;


@Repository
public class DistricReponsitoryILM implements DistricReponsitory{

	
	
	@Override
	public DistrictEntity findNameById(Long id) {
		String sql = "Select d.name From district d where d.id = " + id + ";";
		DistrictEntity districtEntity = new DistrictEntity();
		try (Connection conn =  ConnectJDBCuitl.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql)) {		
			while (rs.next()) {
			districtEntity.setName(rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return districtEntity;
	}

}
