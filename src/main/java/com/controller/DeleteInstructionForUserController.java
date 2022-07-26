package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HouseDao;
import com.dao.InstructionDaoForUser;

public class DeleteInstructionForUserController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int instructionId = Integer.parseInt(request.getParameter("instructionid"));

		InstructionDaoForUser instructionDaoForUser = new InstructionDaoForUser();

		if (instructionDaoForUser.deleteInstructions(instructionId)) {
			request.setAttribute("message", "deleted succecfully");
			System.out.println("deleted succecfully");

		} else {
			request.setAttribute("message", "some error occurs");
			System.out.println("some error occurs in delete");
		}

		request.getRequestDispatcher("ListInstructionForUser").forward(request, response);
	}

}
