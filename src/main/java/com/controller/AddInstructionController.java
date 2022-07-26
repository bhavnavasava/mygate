package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;
import com.dao.InstructionDao;

public class AddInstructionController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isError = false;
		HttpSession session = request.getSession();
		String firstName = request.getParameter("firstname");
		System.out.println(firstName);
		String type = request.getParameter("type");
		System.out.println(type);
		String time = request.getParameter("time");
		System.out.println(time);
		String allow = request.getParameter("allow");
		System.out.println(allow);

		int userId = (Integer) session.getAttribute("userid");

		
		if (isError) {
			System.out.println("in add instructioncontroller false ");
			request.getRequestDispatcher("AddInstruction.jsp").forward(request, response);

		} else {
			System.out.println("in add instructioncontroller true ");

			InstructionDao instructionDao = new InstructionDao();
			InstructionBean instructionBean = new InstructionBean();
			instructionBean.setUserid(userId);
			instructionBean.setFirstName(firstName);
			instructionBean.setType(type);
			instructionBean.setTime(time);
			instructionBean.setAllow(allow);
			instructionDao.insertHouseDetails(instructionBean);
			request.getRequestDispatcher("ListInstruction.jsp").forward(request, response);
		}

	}
}
