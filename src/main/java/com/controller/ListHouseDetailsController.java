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
import com.bean.UserBean;
import com.dao.HouseDao;
import com.dao.UserDao;

public class ListHouseDetailsController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userid");
		HouseDao houseDao = new HouseDao();
		ArrayList<HouseBean> houseDetails = houseDao.getAllHouseDetails(userId);
		request.setAttribute("houseDetails", houseDetails);

		RequestDispatcher rd = request.getRequestDispatcher("ListHouseDetails.jsp");
		rd.forward(request, response);
	}
}
