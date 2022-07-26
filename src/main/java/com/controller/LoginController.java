package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String userType = request.getParameter("usertype");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		UserBean users = userDao.login(email, password);

		if (users == null) {
			request.setAttribute("errorMsg", "Invalid credentials");
			request.getRequestDispatcher("Login.jsp").forward(request, response);

		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", users.getUserId());
			System.out.println(users.getUserType());
			System.out.println(users.getApproved());
			
			if (users.getUserType().equals("user")) {
				if (users.getApproved() == 1) {
					request.getRequestDispatcher("UserHome.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "you are not approved for login");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			} else if (users.getUserType().equals("admin")) {
				if (users.getApproved() == 1) {
					request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "you are not approved for login");

					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			} else if (users.getUserType().equals("guard")) {
				if (users.getApproved() == 1) {
					request.getRequestDispatcher("SecurityHome.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "you are not approved for login");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}

			} else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}

		}

	}
}
