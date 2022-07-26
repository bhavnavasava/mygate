package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SecurityBean;
import com.dao.SecurityDao;

public class ListSecurityDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SecurityDao securityDao=new SecurityDao();
		ArrayList<SecurityBean> securityDetails=securityDao.getAllSecurityDetails();
		request.setAttribute("securityDetails", securityDetails);
		request.getRequestDispatcher("ListSecurityDetails.jsp").forward(request, response);
	}
}
