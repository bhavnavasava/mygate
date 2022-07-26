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
import com.bean.MemberBean;
import com.dao.HouseDao;
import com.dao.MemberDao;

public class ListMembersController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userid");
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberBean> members = memberDao.getAllHouseMembers(userId);
		request.setAttribute("members", members);

		RequestDispatcher rd = request.getRequestDispatcher("ListMember.jsp");
		rd.forward(request, response);
	}
}
