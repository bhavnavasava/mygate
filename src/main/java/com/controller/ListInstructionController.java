package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;
import com.bean.InstructionBean;
import com.dao.HouseDao;
import com.dao.InstructionDao;

public class ListInstructionController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userid");
		InstructionDao instructionDao = new InstructionDao();
		ArrayList<InstructionBean> instructions = instructionDao.getAllInstruction();
		request.setAttribute("instructions", instructions);

		RequestDispatcher rd = request.getRequestDispatcher("ListInstruction.jsp");
		rd.forward(request, response);
	}
}
