package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.dbConnection;

public class UserDao {

	public void insertUser(UserBean userBean) {
		try {
			Connection con = dbConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into users (firstname,lastname,email,password,gender,contactnumber,usertype,approved) values (?,?,?,?,?,?,?,?)");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getContactNumber());
			pstmt.setString(7, userBean.getUserType());
			pstmt.setInt(8, userBean.getApproved());
			int records = pstmt.executeUpdate();
			System.out.println(records + " inserted..");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public UserBean login(String email, String password) {
		UserBean user = null;
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ? ");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			System.out.println(email);
			System.out.println(password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getString("usertype"));
				user.setApproved(rs.getInt("approved"));
				
			}

		} catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int userId = rs.getInt("userid");// db column name
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String userType = rs.getString("usertype");
				int approved = rs.getInt("approved");
				
				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);
				user.setUserType(userType);
				user.setApproved(approved);
				users.add(user);
			}

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}
		return users;
	}

	public int approveUser(int userId) {
		try (Connection con = dbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update users set approved = ? where userid=?");) {
			pstmt.setInt(1, 1);
			pstmt.setInt(2, userId);
			int records = pstmt.executeUpdate();
			return records;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean deleteUser(int userId) {
		boolean flag = false;
		try (Connection con = dbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from users where userid=?");) {
			pstmt.setInt(1, userId);
			int deleteRows = pstmt.executeUpdate();

			if (deleteRows == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public Boolean checkGmailDuplication(String email) {
		UserBean user=null;
		try {
			System.out.println(email);
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from users where email=?");
			pstmt.setString(1, email);
			System.out.println("duplicate method");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{		
				
				System.out.println("check email duplicate method");
				return true;
			}			
		} catch (Exception e) {
			System.out.println("SBM in checkGmailDuplication");
			e.printStackTrace();
		}
		return false;
	}

	public UserBean forgetPassword(String email, String contactNumber) {
		UserBean user = null;
		try(Connection con=dbConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("update users set password=? where email=? and contactnumber=?");
				){
			pstmt.setString(1, email);
			pstmt.setString(2, contactNumber);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				user.setUserId(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setContactNumber(rs.getString("contactnumber"));
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
}
