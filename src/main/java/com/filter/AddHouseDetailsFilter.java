package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bean.HouseBean;
import com.dao.HouseDao;

public class AddHouseDetailsFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isError = false;
		String flateName = request.getParameter("flatename");
		String houseNumber = request.getParameter("housenumber");
		if (flateName == null || flateName.trim().length() == 0) {
			isError = true;
			request.setAttribute("flateNameError", "Please enter flateName");
		}
		if (houseNumber == null || houseNumber.trim().length() == 0) {
			isError = true;
			request.setAttribute("houseNumberError", "Please enter houseNumber");
		}
		if (isError) {
			request.getRequestDispatcher("AddHouseDetails.jsp").forward(request, response);

		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
