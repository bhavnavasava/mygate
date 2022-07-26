package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;
import com.bean.MemberBean;
import com.dao.HouseDao;
import com.dao.MemberDao;

public class AddHouseDetailsController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isError = false;
		HttpSession session=request.getSession();
		String flateName = request.getParameter("flatename");
		String houseNumber = request.getParameter("housenumber");
		int userId = (Integer) session.getAttribute("userid");

		if (isError) {
			System.out.println("in add house details false ");

			request.getRequestDispatcher("AddHouseDetails.jsp").forward(request, response);

		} else {
			System.out.println("in add house details true ");

			HouseDao houseDao = new HouseDao();
			HouseBean houseBean = new HouseBean();
			houseBean.setFlateName(flateName);
			houseBean.setHouseNumber(houseNumber);
			houseBean.setUserId(userId);

			houseDao.insertHouseDetails(houseBean);
			request.getRequestDispatcher("ListHouseDetails.jsp").forward(request, response);
			// rd.forward(request, response);
		}

	}
}
