package com.tharun.cart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    @Override
    public void init() throws ServletException {
    	System.out.println("Init ran");
    	if(getServletContext().getAttribute("ItemMap") != null)
    		return;
    	Map<Integer, Item> m = new HashMap<Integer, Item>();
    	Scanner scanner = null;
    	
    	
		//scanner = new Scanner(new File("C:\\Users\\Work\\Documents\\ItemValues.txt"));
		ServletContext context = getServletContext();
		InputStream resourceContent = context.getResourceAsStream("/WEB-INF/ItemValues.txt");
		scanner = new Scanner(resourceContent);
		
		
    	scanner.useDelimiter("~");
    	while(scanner.hasNextLine()) {
    		String s1 = scanner.findInLine("[^~]*");
			//System.out.println(s1);
			scanner.findInLine("[~]");
			int i1 = Integer.parseInt(scanner.findInLine("[^~]*"));
			System.out.println(i1);
			scanner.findInLine("[~]");
			double i2 = Double.parseDouble(scanner.findInLine("[^~]*"));
			//System.out.println(i2);
			scanner.findInLine("[~]");
			String s2 = scanner.findInLine("[^~]*");
			//System.out.println(s2);
			scanner.findInLine("[~]");
			String s3 = scanner.findInLine("[^~]*");
			//System.out.println(s3);

			String divider = scanner.findInLine("[~]");
			
			HashSet<String> pics = new HashSet<String>();
			pics.add(s3);
			while(divider != null) {
				pics.add(scanner.findInLine("[^~]*"));
				divider = scanner.findInLine("[~]");
			}
			
			Item i = new Item(s1, i1, i2, s2, s3, pics);
    		
    		m.put(i.getId(), i);
    		if(scanner.hasNextLine())
    			scanner.nextLine();
    	}
    	scanner.close();
    	this.getServletContext().setAttribute("ItemMap", m);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HashSet<Item> cart = (HashSet<Item>) session.getAttribute("cart");
		Double total = (Double) session.getAttribute("runningTotal");
		if(cart == null) {
			cart = new HashSet<Item>();
			session.setAttribute("cart", cart);
			total = 0D;
		}
		Integer id = Integer.valueOf(request.getParameter("item"));
		Map<Integer, Item> itemMap = (Map<Integer, Item>)this.getServletContext().getAttribute("ItemMap");
		Item it = itemMap.get(id);
		if(cart.contains(itemMap.get(id))) {
			cart.remove(it);
			total -= it.getPrice();
		}
		else {
			cart.add(it);
			total += it.getPrice();
		}
		session.setAttribute("runningTotal", total);
		
		Integer saveNumber = (Integer) request.getSession().getAttribute("saveNumber");
		if(saveNumber != null)
			StorageFunctions.save(cart, saveNumber);
		
		String nextServlet = "/ShoppingCartPrinter";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextServlet);
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
