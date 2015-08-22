package com.tharun.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class nameList
 */
@WebServlet("/nameList")
public class nameList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nameList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "[";
		HashMap<Integer, Item> list = (HashMap<Integer, Item>) getServletContext().getAttribute("ItemMap");
		int i = 0;
		for(Item item : list.values()) {
			if(i != 0) 
				json += ", ";
			i++;
			json += item.getName();
		}
		json +="]";
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
		
		
	}

}
