package com.tharun.cart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInCheck
 */
@WebServlet("/LogInCheck")
public class LogInCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInCheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File loc = new File("C:\\Users\\Work\\Documents\\Accounts\\" + request.getParameter("userName") + ".txt");
		String password = request.getParameter("password");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		System.out.println("~~" + loc.exists());
		System.out.println("~~" + password);
		if(!loc.exists() || password == null) {
			out.print(0);
			out.close();
			return;
		}
		
		
		FileInputStream fis = new FileInputStream(loc);
		ObjectInputStream ois = new ObjectInputStream(fis);
		String pwd = null;
		Integer saveNumber = null;
		try {
			pwd = (String) ois.readObject();
			saveNumber = (Integer) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(pwd.equals(password)) {
			System.out.println("Successful log in");
			out.print(1);
			request.getSession().setAttribute("saveNumber", saveNumber);
			HashSet<Item> cart = StorageFunctions.load(saveNumber);
			Double total = StorageFunctions.runningTotal(cart);
			
			request.getSession().setAttribute("cart", cart);
			request.getSession().setAttribute("runningTotal", total);
		}
		else
			out.print(0);
		
		out.close();
	}

}
