package com.tharun.cart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Save
 */
@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File newSave = null;
		
		int saveNumber = -1;
		if (request.getSession().getAttribute("savePath") == null) {
			File saves = new File("C:\\Users\\Work\\Documents\\ShoppingCartSaves");
			for (int i = (int) (Math.random() * 100000); true; ++i) {
				File temp = new File(saves, "save" + i + ".txt");
				if (!temp.exists()) {
					saveNumber = i;
					newSave = temp;
					break;
				}
			}
			request.getSession().setAttribute("savePath", newSave);
			request.getSession().setAttribute("saveNumber", saveNumber);
		}
		else {
			newSave = (File) request.getSession().getAttribute("savePath");
			saveNumber = (Integer) request.getSession().getAttribute("saveNumber");
		}
		
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(newSave));
		oos.writeObject((HashSet<Item>)request.getSession().getAttribute("cart"));	
		oos.writeObject((Double)request.getSession().getAttribute("runningTotal"));
		oos.close();
		
		request.setAttribute("saveNumber", saveNumber);
		String nextJSP = "/SaveDisplay.jsp";
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
