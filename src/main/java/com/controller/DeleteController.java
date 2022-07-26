package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
public class DeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userid"));

	UserDao userDao = new UserDao();

	if (userDao.deleteUser(userId)) {
		request.setAttribute("message", "deleted succecfully");

	} else {
		request.setAttribute("message", "some error occurs");
	}

	request.getRequestDispatcher("ListUserController").forward(request, response);
}


}
