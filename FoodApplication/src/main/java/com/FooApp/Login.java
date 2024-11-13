package com.FooApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FooApp.Security.Decrypt;
import com.FoodApp.DAOImpl.RestaurantDAOImpl;
import com.FoodApp.DAOImpl.UserDAOImpl;
import com.FoodApp.UserModel.User;


public class Login extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=Decrypt.Decrypt(req.getParameter("email"));
		String password=Decrypt.Decrypt(req.getParameter("password"));
		UserDAOImpl udaoi=new UserDAOImpl();
		
		User u=udaoi.getUser(email);
		
		if(u!=null) {
			if(u.getPassword().equals(password)) {
				HttpSession session=req.getSession();
				session.setAttribute("loggedInUser",u);
				resp.sendRedirect("GetRestaurant");
			}
			else {
				resp.sendRedirect("pwdIncorrect.jsp");
			}
		}
		else {
			resp.sendRedirect("inValid.jsp");
		}
	}
}
