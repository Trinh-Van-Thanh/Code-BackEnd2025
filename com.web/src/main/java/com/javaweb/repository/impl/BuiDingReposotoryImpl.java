package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuidingRepository;
import com.javaweb.repository.entity.BuiDingEntity;
import com.javaweb.service.util.ConnectJDBCuitl;
import com.javaweb.service.util.Numberutil;
import com.javaweb.service.util.Stringulit;

@Repository
public class BuiDingReposotoryImpl implements BuidingRepository {
	

	public static void joinTable(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
		String staffid = (String) params.get("staffId");
		if (Stringulit.checkString(staffid)) {
			sql.append("INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		if (typeCode != null && typeCode.size() != 0) {
			sql.append("INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append("INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
		}
//		String rentAreaTo = (String) params.get("areaTo");
//		String rentAreaFrom = (String) params.get("areaFrom");
//		if (Stringulit.checkString(rentAreaFrom) == true && Stringulit.checkString(rentAreaTo) == true) {
//			sql.append("INNER JOIN rentarea ON rentarea.buildingid = b.id ");
//		}
	}

	public static void query(Map<String, Object> params, StringBuilder where) {
		for (Map.Entry<String, Object> it : params.entrySet()) {
			if (!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") && !it.getKey().startsWith("area")
					&& !it.getKey().startsWith("rentPrice")) {
				String value = it.getValue().toString();
				if (Stringulit.checkString(value)) {
					if (Numberutil.isNumber(value) == true) {
						where.append(" AND b. " + it.getKey() + " = " + value);
					} else {
						where.append(" AND b. " + it.getKey() + " LIKE '%" + value + "%' ");
					}
				}
			}
		}
	}
	public static void querySpecial(Map<String, Object> params, List<String> typeCode, StringBuilder where) {
		String staffid = (String) params.get("staffId");
		if(Stringulit.checkString(staffid)) {
			where.append(" AND assignmentbuilding.staffId = " + staffid);
		}
		String rentAreaTo = (String) params.get("areaTo");
		String rentAreaFrom = (String) params.get("areaFrom");
		if (Stringulit.checkString(rentAreaFrom) == true && Stringulit.checkString(rentAreaTo) == true) { 
			
			where.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid");
			if(Stringulit.checkString(rentAreaFrom)) {
				where.append(" AND r.value >=" + rentAreaFrom);
			}
			if(Stringulit.checkString(rentAreaTo)) {
				where.append(" AND r.value =<" + rentAreaTo);
			}
			where.append(" ) ");
		}
		String rentPriceTo = (String) params.get("rentPriceTo");
		String rentPriceFrom = (String) params.get("rentPriceFrom");
		if (Stringulit.checkString(rentPriceFrom) == true && Stringulit.checkString(rentPriceTo) == true) {
			if(Stringulit.checkString(rentPriceFrom)) {
				where.append(" AND b.rentprice >=" + rentPriceFrom);
			}
			if(Stringulit.checkString(rentPriceTo)) {
				where.append(" AND b.rentprice >=" + rentPriceTo);
			}
		}
		// java 7
//		if(typeCode != null && typeCode.size() != 0 ) {
//			where.append(" AND renttype.code IN(" + String.join(",", typeCode) + ")");
//			
//			List<String> code  = new ArrayList<String>();
//			for(String item: typeCode) {
//				code.add("'" + item + "'");
//			}
//			where.append(" AND renttype.code IN(" + String.join(",", code) + ") ");
//		}
		
		// nâng cấp lên java 8
		if(typeCode != null && typeCode.size() != 0 ) {
			where.append(" AND (");
			String sql = typeCode.stream().map(it-> "renttype.code LIKE" + "'%" + it +"%'").collect(Collectors.joining(" OR "));
			where.append(sql);
			where.append(" ) ");
		}
		
	}
	@Override
	public List<BuiDingEntity> findAll(Map<String, Object> params, List<String> typeCode) {
		StringBuilder sql = new StringBuilder("select b.id, b.name,b.street,b.districtid, b.ward, b.numberofbasement, b.floorarea, b.rentprice,b.managername,b.managerphonenumber, b.servicefee, b.brokeragefee from building b ");
		joinTable(params, typeCode, sql);
		StringBuilder where = new StringBuilder(" where 1 = 1 ");
		query(params, where);
		querySpecial(params, typeCode, where);
		where.append("GROUP BY b.id;");
		sql.append(where);
		System.out.print(sql);
		List<BuiDingEntity> result = new ArrayList<>();
		try (Connection conn = ConnectJDBCuitl.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuiDingEntity buiding = new BuiDingEntity();
				buiding.setId(rs.getLong("b.id"));
				buiding.setName(rs.getString("b.name"));
				buiding.setWrad(rs.getString("b.ward"));
				buiding.setDistrictid(rs.getString("b.districtid"));
				buiding.setStreet(rs.getString("b.street"));
				buiding.setFloorArea(rs.getLong("b.floorArea"));
				buiding.setRentPrice(rs.getLong("b.rentprice"));
				buiding.setServiceFee(rs.getString("b.servicefee"));
				buiding.setBrokerageFee(rs.getLong("b.brokeragefee"));
				buiding.setManagerName(rs.getString("b.managername"));
				buiding.setManagerPhoneNumber(rs.getString("b.managerphonenumber"));
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
