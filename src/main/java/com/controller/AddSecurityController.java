package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;
import com.bean.SecurityBean;
import com.bean.UserBean;
import com.dao.InstructionDao;
import com.dao.SecurityDao;
import com.dao.UserDao;

public class AddSecurityController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isError = false;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String contactNumber = request.getParameter("contactNumber");
		int isActive=Integer.parseInt(request.getParameter("isactive"));

		System.out.println(firstName);
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "Please enter FirstName");
		}
		if (lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError", "Please enter lastName");
		}

		if (contactNumber == null || contactNumber.trim().length() == 0) {
			isError = true;
			request.setAttribute("contactNumberError", contactNumber);
		}
		if (isError) {

			System.out.println("sign ");
			request.getRequestDispatcher("Signup.jsp").forward(request, response);

		} else {

			System.out.println("loxgin");
			SecurityDao securityDao = new SecurityDao();
			SecurityBean securityBean = new SecurityBean();
			securityBean.setFirstName(firstName);
			securityBean.setLastName(lastName);
			securityBean.setContactNumber(contactNumber);
			securityBean.setIsActive(isActive);
			
			
			securityDao.insertSecurity(securityBean);
			request.getRequestDispatcher("ListSecurityDetailController").forward(request, response);

			// rd.forward(request, response);
		}

	}

}
