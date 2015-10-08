package com.tharun.cart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserNameCheck
 */
@WebServlet("/UserNameCheck")
public class UserNameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File loc = new File(System.getenv("OSTORE_HOME") + "Accounts\\" + request.getParameter("userName") + ".txt");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		System.out.println(loc.exists());
		System.out.println(email);
		System.out.println(password);
		System.out.println(name);
		if(loc.exists() || email == null || password == null || name == null) {
			out.print(0);
			out.close();
			return;
		}

		loc.createNewFile();
		Integer saveNumber = (Integer) request.getSession().getAttribute("saveNumber");
		HashSet<Item> cart = (HashSet<Item>)request.getSession().getAttribute("cart");
		saveNumber = StorageFunctions.save(cart, saveNumber);
		request.getSession().setAttribute("saveNumber", saveNumber);
		request.getSession().setAttribute("clientName", name);
		
		
		FileOutputStream fos = new FileOutputStream(loc);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(password);
		oos.writeObject(saveNumber);
		oos.writeObject(name);
		
		
		out.print(1);
		out.close();
	}

}
