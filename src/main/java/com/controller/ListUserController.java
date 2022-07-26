package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class ListUserController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userid");
		UserDao userDao = new UserDao();
		ArrayList<UserBean> users = userDao.getAllUsers();
		request.setAttribute("users", users);

		RequestDispatcher rd = request.getRequestDispatcher("ListUser.jsp");
		rd.forward(request, response);
	}
}
