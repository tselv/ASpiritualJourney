package com.tharun.cart;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File loc = new File("C:\\Users\\Work\\Documents\\Accounts\\" + request.getParameter("userName") + ".txt");
		response.setContentType("text/plain");
		System.out.println("The Username servlet was called:");
		System.out.println(request.getParameter("userName"));
		PrintWriter out = response.getWriter();
		if(loc.exists())
			out.print(0);
		else
			out.print(1);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File loc = new File("C:\\Users\\Work\\Documents\\Accounts\\" + request.getParameter("userName") + ".txt");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		if(loc.exists())
			out.print(0);
		else
			out.print(1);
		out.close();
	}

}
