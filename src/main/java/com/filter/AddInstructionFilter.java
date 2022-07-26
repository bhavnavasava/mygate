package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public class AddInstructionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String firstName = request.getParameter("firstname");
		System.out.println(firstName);
		String type = request.getParameter("type");
		System.out.println(type);
		String time = request.getParameter("time");
		System.out.println(time);
		String allow = request.getParameter("allow");
		System.out.println(allow);
		boolean isError = false;
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "Please enter firstName");
		}
		if (type == null || type.trim().length() == 0) {
			isError = true;
			request.setAttribute("typeError", "Please enter type");
		}
		if (time == null || time.trim().length() == 0) {
			isError = true;
			request.setAttribute("timeError", "Please enter time");
		}
		if (time == null || time.trim().length() == 0) {
			isError = true;
			request.setAttribute("timeError", "Please enter time");
		}
		if (allow == null || allow.trim().length() == 0) {
			isError = true;
			request.setAttribute("allowError", "Please atleast select one allow or not");
		}
		if (isError == true) {
			request.getRequestDispatcher("AddInstruction.jsp").forward(request, response);
		} else {
			// go ahead
			chain.doFilter(request, response);// servlet -- second filter
		}
	}

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
