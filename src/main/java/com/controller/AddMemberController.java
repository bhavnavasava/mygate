package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;
import com.bean.MemberBean;
import com.bean.UserBean;
import com.dao.HouseDao;
import com.dao.MemberDao;
import com.dao.UserDao;

public class AddMemberController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean isError = false;		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String contactNumber = request.getParameter("contactnumber");
		//int houseId = Integer.parseInt(request.getParameter("houseid"));

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userid");
		
		

		System.out.println(userId);
		
		if (isError) {

			System.out.println(" addmembercontroller::: iserror");
			request.getRequestDispatcher("AddMember.jsp").forward(request, response);

		} else {
			HouseDao houseDao=new HouseDao();
			HouseBean houseBean=new HouseBean();
			MemberDao memberDao = new MemberDao();
			MemberBean memberBean = new MemberBean();
			memberBean.setFirstName(firstName);
			memberBean.setAge(age);
			//memberBean.setHouseId(houseId);
			//memberBean.setMemberId(memberId);
			memberBean.setLastName(lastName);
			memberBean.setGender(gender);
			memberBean.setUserId(userId);
			memberBean.setContactNumber(contactNumber);
			//memberBean.setHouseId(houseBean.getHouseId());
			System.out.println("addmembercontroller  ::: else");
			memberDao.insertMember(memberBean);
			request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
			// rd.forward(request, response);
		}

	}

}
