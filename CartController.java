package com.FoodApp.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodApp.DAOImpl.CartDAOImpl;
import com.FoodApp.DAOImpl.MenuDAOImpl;
import com.FoodApp.UserModel.CartItem;
import com.FoodApp.UserModel.Menu;


public class CartController extends HttpServlet {
	private Map<Integer, CartItem> cart;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().getAttribute("cart");
		if(cart==null) {
			this.cart=new HashMap<Integer, CartItem>();
			
		}
		String x = req.getParameter("MenuId");
		int menuId=Integer.parseInt(x);
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAOImpl mdio=new MenuDAOImpl();
		
		Menu m=mdio.fetchSpecific(menuId);
		
		CartItem ci=new CartItem(menuId,m.getRestaurantId(), m.getName(), quantity, m.getPrice());
		
		CartDAOImpl cdaio=new CartDAOImpl();
		
		cart=cdaio.addItem(ci);;
		
		req.getSession().setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
		
	}

}
