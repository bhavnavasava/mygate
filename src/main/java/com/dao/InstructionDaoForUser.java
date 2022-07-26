package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.InstructionBean;
import com.util.dbConnection;

public class InstructionDaoForUser {
	public ArrayList<InstructionBean> getAllInstruction(int userId) {

		ArrayList<InstructionBean> instructionsForUser = new ArrayList<InstructionBean>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from instruction where userid=?");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next() == true) {
				String firstName = rs.getString("firstname");
				String type = rs.getString("type");
				String time = rs.getString("time");
				int instructionId = rs.getInt("instructionId");
				String allow = rs.getString("allow");
				// int userId=rs.getInt("userid");

				InstructionBean instruction = new InstructionBean();
				instruction.setUserid(userId);
				instruction.setInstructionid(instructionId);
				instruction.setFirstName(firstName);
				instruction.setType(type);
				instruction.setTime(time);
				instruction.setAllow(allow);
				instructionsForUser.add(instruction);
			}

		} catch (Exception e) {
			System.out.println("SMW in InstructionDAOforuser::getAllInstruction()");
			e.printStackTrace();
		}
		return instructionsForUser;

	}

	public boolean deleteInstructions(int instructionId) {
		boolean flag = false;
		try (Connection con = dbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from instruction where instructionid=?");) {
			pstmt.setInt(1, instructionId);
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
