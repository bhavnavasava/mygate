package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.HouseBean;
import com.bean.MemberBean;
import com.bean.UserBean;
import com.util.dbConnection;

public class MemberDao {
	public void insertMember(MemberBean memberBean) {
		try {
			Connection con = dbConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into members (firstname,lastname,gender,age,contactnumber,userid) values (?,?,?,?,?,?)");
			pstmt.setString(1, memberBean.getFirstName());
			pstmt.setString(2, memberBean.getLastName());
			pstmt.setString(3, memberBean.getGender());
			pstmt.setInt(4, memberBean.getAge());
			pstmt.setString(5, memberBean.getContactNumber());
			pstmt.setInt(6, memberBean.getUserId());
		   // pstmt.setInt(7, memberBean.getHouseId());
			int records = pstmt.executeUpdate();
			System.out.println(records + " inserted..");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public ArrayList<MemberBean> getAllHouseMembers(int userId) {
		ArrayList<MemberBean> members = new ArrayList<MemberBean>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from members where userid=?  ");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next() == true) {

				int memberId = rs.getInt("memberid");
				System.out.println(memberId);
				String firstName = rs.getString("firstname");
				System.out.println(firstName);
				String lastName = rs.getString("lastname");
				System.out.println(lastName);
				String gender = rs.getString("gender");
				System.out.println(gender);
				int age = rs.getInt("age");
				System.out.println(age);
				String contactNumber = rs.getString("contactnumber");
				System.out.println(contactNumber);
				//int houseId=rs.getInt("houseid");

				MemberBean member = new MemberBean();
				member.setMemberId(memberId);
				//member.setHouseId(houseId);
				member.setFirstName(firstName);
				member.setLastName(lastName);
				member.setGender(gender);
				member.setUserId(userId);
				member.setAge(age);
				member.setContactNumber(contactNumber);
				members.add(member);

			}

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}
		return members;

	}

	public boolean deleteMember(int memberId) {
		boolean flag = false;
		try (Connection con = dbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from members where memberid=?");) {
			pstmt.setInt(1, memberId);
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
