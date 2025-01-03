package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuidingRepository;
import com.javaweb.repository.entity.BuiDingEntity;

@Repository
public class BuiDingReposotoryImpl implements BuidingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String USER = "root";
	static final String PASS = "root";
	@Override
	public List<BuiDingEntity> findAll(String name, Long districtId) {
		StringBuilder sql = new StringBuilder( "select * from buiding b where 1 = 1 ");
		if(name != null && !name.equals("")) {
			sql.append("AND b.name like '%" + name + "%' ");
		}
		if(districtId != null) {
			sql.append("AND b.districtid = " + districtId + " ");
		}
		List<BuiDingEntity> result = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());){
			while(rs.next()) {
				BuiDingEntity buiding = new BuiDingEntity();
				buiding.setName(rs.getString("name"));
				buiding.setSterrt(rs.getString("street"));
				buiding.setWard(rs.getString("ward"));
				buiding.setNumberOfBasement(rs.getInt("numberofbasement"));
				result.add(buiding);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
