package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class SignupController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("Login.jsp");
		boolean isError = false;
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String userType = request.getParameter("usertype");
		String contactNumber = request.getParameter("contactnumber");

		System.out.println(firstName);
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "Please enter FirstName");
		}
		if (lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError", "Please enter lastName");
		}
		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please enter email");
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "Please enter password");
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

			System.out.println("signup ");
			request.getRequestDispatcher("Signup.jsp").forward(request, response);

		} else {

			UserDao userDao = new UserDao();
			UserBean userBean = new UserBean();
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);
			userBean.setContactNumber(contactNumber);
			userBean.setUserType("user");
			userBean.setApproved(0);

			userDao.insertUser(userBean);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}

}
