package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.repository.BuidingRepository;
import com.javaweb.repository.entity.BuiDingEntity;
import com.javaweb.service.util.ConnectJDBCuitl;
import com.javaweb.service.util.Numberutil;
import com.javaweb.service.util.Stringulit;

@Repository
@PropertySource("classpath:application.properties")
public class BuiDingReposotoryImpl implements BuidingRepository {

	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String USER;
	
	@Value("${spring.datasource.password}")
	private String PASS;
	
	
	public static void joinTable(BuildingSearchBuilder buiSearchBuilder, StringBuilder sql) {
		Long staffid = buiSearchBuilder.getStaffId();
		if (staffid != null) {
			sql.append("INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		List<String> typeCode = buiSearchBuilder.getTypeCode();
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

	public static void query(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
//		for (Map.Entry<String, Object> it : params.entrySet()) {
//			if (!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") && !it.getKey().startsWith("area")
//					&& !it.getKey().startsWith("rentPrice")) {
//				String value = it.getValue().toString();
//				if (Stringulit.checkString(value)) {
//					if (Numberutil.isNumber(value) == true) {
//						where.append(" AND b. " + it.getKey() + " = " + value);
//					} else {
//						where.append(" AND b. " + it.getKey() + " LIKE '%" + value + "%' ");
//					}
//				}
//			}
//		}
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if (!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("area")
						&& !fieldName.startsWith("rentPrice")) {
					Object value = item.get(buildingSearchBuilder);
					if (value != null) {
						if (item.getType().getName().equals("java.lang.Long")
								|| item.getType().getName().equals("java.lang.Integer")) {
							where.append(" AND b. " + fieldName + " = " + value);
						} else if (item.getType().getName().equals("java.lang.String")) {
							where.append(" AND b. " + fieldName + " LIKE '%" + value + "%' ");
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		Long staffid = buildingSearchBuilder.getStaffId();
		if (staffid != null) {
			where.append(" AND assignmentbuilding.staffId = " + staffid);
		}
		Long rentAreaTo = buildingSearchBuilder.getAreaTo();
		Long rentAreaFrom = buildingSearchBuilder.getAreaFrom();
		if (rentAreaFrom != null && rentAreaTo != null) {

			where.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid");
			if (rentAreaFrom != null) {
				where.append(" AND r.value >=" + rentAreaFrom);
			}
			if (rentAreaTo != null) {
				where.append(" AND r.value =<" + rentAreaTo);
			}
			where.append(" ) ");
		}
		Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();
		Long rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
		if (rentPriceFrom != null && rentPriceTo != null) {
			if (rentPriceFrom != null) {
				where.append(" AND b.rentprice >=" + rentPriceFrom);
			}
			if (rentPriceTo != null) {
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
		List<String> typeCode = buildingSearchBuilder.getTypeCode();
		if (typeCode != null && typeCode.size() != 0) {
			where.append(" AND (");
			String sql = typeCode.stream().map(it -> "renttype.code LIKE" + "'%" + it + "%'")
					.collect(Collectors.joining(" OR "));
			where.append(sql);
			where.append(" ) ");
		}

	}

	@Override
	public List<BuiDingEntity> findAll(BuildingSearchBuilder buiSearchBuilder) {
		StringBuilder sql = new StringBuilder(
				"select b.id, b.name,b.street,b.districtid, b.ward, b.numberofbasement, b.floorarea, b.rentprice,b.managername,b.managerphonenumber, b.servicefee, b.brokeragefee from building b ");
		joinTable(buiSearchBuilder, sql);
		StringBuilder where = new StringBuilder(" where 1 = 1 ");
		query(buiSearchBuilder, where);
		querySpecial(buiSearchBuilder, where);
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
