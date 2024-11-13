package com.FooApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FooApp.Security.Encrypt;
import com.FoodApp.DAOImpl.UserDAOImpl;
import com.FoodApp.UserModel.User;

public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u=new User(
				req.getParameter("username"), 
				Encrypt.encrypt(req.getParameter("email")),
				Encrypt.encrypt(req.getParameter("password")),
				req.getParameter("mobile"));
		
		UserDAOImpl ud= new UserDAOImpl();
		int x=ud.insert(u);
		if(x==1) {
			resp.sendRedirect("Success.jsp");
		}
		else {
			resp.sendRedirect("inValid.jsp");
		}
	}
}
