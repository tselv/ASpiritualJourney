package com.tharun.cart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Load
 */
@WebServlet("/Load")
public class Load extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer saveNumber = Integer.parseInt(request.getParameter("saveNumber"));
		
		File loc = new File("C:\\Users\\Work\\Documents\\ShoppingCartSaves\\save" + saveNumber + ".txt");
		if(!loc.exists()) {
			response.sendRedirect("./LoadDisplay.jsp");
			return;
		}
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loc));
		Set<Item> cart = null;
		Double total = null;
		try {
			cart = (Set<Item>) ois.readObject();
			total = (Double) ois.readObject();	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ois.close();
		request.getSession().setAttribute("cart", cart);
		request.getSession().setAttribute("runningTotal", total);
		request.getSession().setAttribute("savePath", loc);
		request.getSession().setAttribute("saveNumber", saveNumber);
		
		String nextJSP = "/ShoppingCartPrinter";
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
