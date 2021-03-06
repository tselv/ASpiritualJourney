package com.tharun.cart;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCartPrinter
 */
@WebServlet("/ShoppingCartPrinter")
public class ShoppingCartPrinter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<Item> cart = (Set<Item>) request.getSession().getAttribute("cart");
		Double total = (Double) request.getSession().getAttribute("runningTotal");
		HttpSession session = request.getSession();
		if(cart == null) {
			cart = new HashSet<Item>();
			session.setAttribute("cart", cart);
			total = 0D;
			session.setAttribute("runningTotal", total);
		}
		
		
		StringBuilder itemList = new StringBuilder();
		System.out.println("Cart: " + cart);
		for(Item i : cart) 
			itemList.append(i.getName() + ", ");
		if(itemList.length() > 0)
			itemList.delete(itemList.length()-2, itemList.length());
		DecimalFormat df = new DecimalFormat("#.00");
		request.setAttribute("Cost", df.format(total));
		request.setAttribute("ItemsInCart", itemList);
		request.setAttribute("items", cart);
		
		String nextJSP = "/CartDisplay.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
