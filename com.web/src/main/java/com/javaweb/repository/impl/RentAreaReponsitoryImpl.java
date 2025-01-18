package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.RentAreaReponsitory;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.service.util.ConnectJDBCuitl;
@Repository
public class RentAreaReponsitoryImpl implements RentAreaReponsitory{

	@Override
	public List<RentAreaEntity> getvalueByBuiDingId(Long id) {
		String sql = "Select * from rentarea where rentarea.buildingid = " + id;
		List<RentAreaEntity> renAreas = new ArrayList<RentAreaEntity>();
		try (Connection conn =  ConnectJDBCuitl.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setValue(rs.getString("value"));
				renAreas.add(rentAreaEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return renAreas;
	}

}
