package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.entity.BuiDingEntity;
import com.javaweb.repository.entity.DistrictEntity;

@Repository
public class DistricReponsitoryILM implements DistricReponsitory{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "root";
	
	
	@Override
	public DistrictEntity findNameById(Long id) {
		String sql = "Select d.name From district d where d.id = " + id + ";";
		DistrictEntity districtEntity = new DistrictEntity();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
