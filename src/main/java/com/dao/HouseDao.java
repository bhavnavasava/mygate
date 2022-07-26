package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.HouseBean;
import com.util.dbConnection;

public class HouseDao {

	public void insertHouseDetails(HouseBean houseBean) {
		try {
			Connection con = dbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("insert into housetable (flatename,housenumber,userid) values (?,?,?)");
			pstmt.setString(1, houseBean.getFlateName());
			pstmt.setString(2, houseBean.getHouseNumber());
			pstmt.setInt(3, houseBean.getUserId());

			int records = pstmt.executeUpdate();
			System.out.println(records + " inserted..");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public ArrayList<HouseBean> getAllHouseDetails(int userId) {
		ArrayList<HouseBean> houseDetails = new ArrayList<HouseBean>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from housetable where userid=?");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next() == true) {
				//int userId = rs.getInt("userid");// db column name
				String flateName = rs.getString("flatename");
				int houseId=rs.getInt("houseid");
				String houseNumber = rs.getString("housenumber");

				HouseBean house = new HouseBean();
				house.setUserId(userId);
				house.setHouseId(houseId);
				house.setFlateName(flateName);
				house.setHouseNumber(houseNumber);
				houseDetails.add(house);
			}

		} catch (Exception e) {
			System.out.println("SMW in HOUSEDAO::getAllHouse()");
			e.printStackTrace();
		}
		return houseDetails;

	}

	public boolean deleteHouseDetails(int houseId) {
		boolean flag = false;
		try (Connection con = dbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from housetable where houseid=?");) {
			pstmt.setInt(1, houseId);
			int deleteRows = pstmt.executeUpdate();

			if (deleteRows == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}
