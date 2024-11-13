package com.FooApp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodApp.DAOImpl.MenuDAOImpl;
import com.FoodApp.UserModel.Menu;


public class ViewMenu extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String x =req.getParameter("restId");
		int restaurantId = Integer.parseInt(x);
		
		System.out.println("View Menu Java");
		System.out.println(x);//1
		System.out.println(restaurantId);//1
		MenuDAOImpl mdio=new MenuDAOImpl();
		List<Menu> m=mdio.fetchAll(restaurantId);
		//List<Menu> menuList = mdio.FetchMenu(m);
		 req.getSession().setAttribute("menuList",m);
	        resp.sendRedirect("Menu.jsp");
		
	}
}
	