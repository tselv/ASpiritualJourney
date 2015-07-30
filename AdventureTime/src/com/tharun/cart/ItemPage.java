package com.tharun.cart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ItemPage
 */
@WebServlet("/ItemPage")
public class ItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Set<Item> cart = (Set<Item>) session.getAttribute("cart");
		Double total = (Double) session.getAttribute("runningTotal");
		if(cart == null) {
			cart = new HashSet<Item>();
			session.setAttribute("cart", cart);
			total = 0D;
			session.setAttribute("runningTotal", total);
		}
		
		Integer itemId = Integer.valueOf(request.getParameter("itemId"));
		Item requestedItem = (Item) ((Map)getServletContext().getAttribute("ItemMap")).get(itemId);
		
		request.setAttribute("ItemName", requestedItem.getName());
		request.setAttribute("ItemImageLoc", requestedItem.getImageLoc());
		request.setAttribute("ItemDescription", requestedItem.getDescription());
		request.setAttribute("ItemId", requestedItem.getId());
		request.setAttribute("ItemPrice", "$" + requestedItem.getPrice());
		request.setAttribute("ItemImageLocs", requestedItem.getImageLocs());
		if(cart.contains(requestedItem))
			request.setAttribute("cartOption", "Remove From Cart");
		else
			request.setAttribute("cartOption", "Add to Cart");
		
		String nextJSP = "/ItemPageJSP.jsp";
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
