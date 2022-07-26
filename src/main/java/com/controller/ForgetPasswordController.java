package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class ForgetPasswordController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String contactNumber = request.getParameter("contactnumber");
		UserDao userDao = new UserDao();
		UserBean user = userDao.forgetPassword(email,contactNumber);
		if (user == null) {
			request.setAttribute("message", "Invalid Email Address");
			request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
		} else {
			request.setAttribute("email", email);
			request.setAttribute("contactNumber",contactNumber);
			
			request.getRequestDispatcher("ResetPassword.jsp").forward(request, response);
			
		}
	}

}
