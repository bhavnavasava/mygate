package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;
import com.dao.InstructionDao;
import com.dao.InstructionDaoForUser;

public class ListInstructionForUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userid");
		InstructionDaoForUser instructionDaoForUser = new InstructionDaoForUser();
		ArrayList<InstructionBean> instructionsForUser = instructionDaoForUser.getAllInstruction(userId);
		request.setAttribute("instructionsForUser", instructionsForUser);

		RequestDispatcher rd = request.getRequestDispatcher("ListInstructionForUser.jsp");
		rd.forward(request, response);
	}
}
