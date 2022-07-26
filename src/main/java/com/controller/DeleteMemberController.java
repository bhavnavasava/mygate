package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MemberBean;
import com.dao.MemberDao;

public class DeleteMemberController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int memberId = Integer.parseInt(request.getParameter("memberid"));
		MemberDao memberDao = new MemberDao();
		if (memberDao.deleteMember(memberId)) {
			request.setAttribute("message", "deleted succecfully");
			System.out.println("deleted succecfully");

		} else {
			request.setAttribute("message", "some error occurs");
			System.out.println("some error occurs in delete");
		}

		request.getRequestDispatcher("ListMembersController").forward(request, response);
	}
}
