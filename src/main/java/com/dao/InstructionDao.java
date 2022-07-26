package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.HouseBean;
import com.bean.InstructionBean;
import com.util.dbConnection;

public class InstructionDao {

	public void insertHouseDetails(InstructionBean instructionBean) {
		try {
			Connection con = dbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("insert into instruction (firstname,type,userid,time,allow) values (?,?,?,?,?)");
			pstmt.setString(1, instructionBean.getFirstName());
			pstmt.setString(2, instructionBean.getType());
			pstmt.setInt(3, instructionBean.getUserid());
			pstmt.setString(4, instructionBean.getTime());
			pstmt.setString(5, instructionBean.getAllow());
			int records = pstmt.executeUpdate();
			System.out.println(records + " inserted..");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public ArrayList<InstructionBean> getAllInstruction() {
		ArrayList<InstructionBean> instructions = new ArrayList<InstructionBean>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from instruction");
			//pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next() == true) {
				String firstName = rs.getString("firstname");
				String type = rs.getString("type");
				String time = rs.getString("time");
				String allow = rs.getString("allow");
				int userId=rs.getInt("userid");

				InstructionBean instruction = new InstructionBean();
				instruction.setUserid(userId);
				instruction.setFirstName(firstName);
				instruction.setType(type);
				instruction.setTime(time);
				instruction.setAllow(allow);
				instructions.add(instruction);
			}

		} catch (Exception e) {
			System.out.println("SMW in InstructionDAO::getAllInstruction()");
			e.printStackTrace();
		}
		return instructions;

	}
}
