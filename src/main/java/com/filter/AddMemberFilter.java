package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bean.MemberBean;
import com.dao.MemberDao;

public class AddMemberFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isError = false;
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		//int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String houseId=request.getParameter("houseid");
		String contactNumber = request.getParameter("contactnumber");
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "Please enter FirstName");
		}
		if (lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError", "Please enter lastName");
		}
		if (gender == null || gender.trim().length() == 0) {
			isError = true;
			request.setAttribute("genderError", "Please enter gender ");
		}
		if (contactNumber == null || contactNumber.trim().length() == 0) {
			isError = true;
			request.setAttribute("contactNumberError", contactNumber);
		}
		
		if (isError) {
			request.getRequestDispatcher("AddMember.jsp").forward(request, response);

		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
