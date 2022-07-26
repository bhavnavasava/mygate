package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HouseDao;
import com.dao.UserDao;

public class DeleteHouseDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int houseId = Integer.parseInt(request.getParameter("houseid"));

		HouseDao houseDao = new HouseDao();

		if (houseDao.deleteHouseDetails(houseId)) {
			request.setAttribute("message", "deleted succecfully");
			System.out.println("deleted succecfully");

		} else {
			request.setAttribute("message", "some error occurs");
			System.out.println("some error occurs in delete");
		}

		request.getRequestDispatcher("ListHouseDetailsController").forward(request, response);
	}

}
