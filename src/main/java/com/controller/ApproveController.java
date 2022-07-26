package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;

public class ApproveController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId =Integer.parseInt(request.getParameter("userid"));

		UserDao userdao = new UserDao();

		int records = userdao.approveUser(userId);
		RequestDispatcher rd = null;
		if (records == 1) {
			request.setAttribute("message", "Successfully Approved");
			rd = request.getRequestDispatcher("ListUser.jsp");
		} else {
			request.setAttribute("message", "SomeThing went Wrong");

			rd = request.getRequestDispatcher("ListUser.jsp");
		}
		rd.forward(request, response);
	}
}
