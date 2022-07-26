package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.SecurityBean;
import com.util.dbConnection;

public class SecurityDao {

	public void insertSecurity(SecurityBean securityBean) {
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into security (firstname,lastname,contactnumber,isactive) values(?,?,?,?)");
			pstmt.setString(1, securityBean.getFirstName());
			pstmt.setString(2, securityBean.getLastName());
			pstmt.setString(3, securityBean.getContactNumber());
			pstmt.setInt(4, securityBean.getIsActive());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<SecurityBean> getAllSecurityDetails() {
		ArrayList<SecurityBean> securityDetails = new ArrayList<>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from security ");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int securityId=rs.getInt("securityId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastname");
				String contactNumber = rs.getString("contactnumber");
				int isActive = rs.getInt("isactive");

				SecurityBean security = new SecurityBean();
				security.setFirstName(firstName);
				security.setLastName(lastName);
				security.setSecurityId(securityId);
				security.setContactNumber(contactNumber);
				security.setIsActive(isActive);
				securityDetails.add(security);
			}
		} catch (Exception e) {
			System.out.println("SMW in SecurityDAO::getAllSecurityDetails()");
			e.printStackTrace();
		}

		return securityDetails;

	}

}
