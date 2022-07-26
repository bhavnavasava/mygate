package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class DuplicateEmailFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String email = request.getParameter("email");
		
		UserDao userDao=new UserDao();
		
		Boolean d1=userDao.checkGmailDuplication(email);
		if(d1==true)
		{
			System.out.println("duplicate email true");
			request.setAttribute("email", "<font color='red'>Duplicate email not valid");
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		}
		else {
			
			System.out.println("duplicate email false");
			UserBean userBean = new UserBean();
			
			userBean.setEmail(email);
			userDao.insertUser(userBean);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}
		
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
