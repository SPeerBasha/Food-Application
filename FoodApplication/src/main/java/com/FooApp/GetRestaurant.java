package com.FooApp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FoodApp.DAOImpl.RestaurantDAOImpl;
import com.FoodApp.UserModel.Restaurant;
//
///**
// * Servlet implementation class GetRestaurant
// */
//@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAOImpl rs=new RestaurantDAOImpl();
		List<Restaurant> r=rs.fetchAll();
		System.out.println("GetRestaurant \n"+r);
		if(r!=null) {
			
				HttpSession session=req.getSession();
				session.setAttribute("restaurantList",r);
				resp.sendRedirect("Home.jsp");
		}
			else {
				resp.sendRedirect("pwdIncorrect.jsp");
			}
//		Restaurant r=new Restaurant();
		
		
	}

}
