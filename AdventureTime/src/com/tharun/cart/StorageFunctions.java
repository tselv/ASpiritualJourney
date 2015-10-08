package com.tharun.cart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class StorageFunctions {
	
	public static Integer save(HashSet<Item> cart, Integer saveNumber) throws FileNotFoundException, IOException {
		File saves = new File(System.getenv("OSTORE_HOME") + "ShoppingCartSaves");
		if(saveNumber == null)
			for (int i = (int) (Math.random() * 100000); true; ++i) {
				File temp = new File(saves, "save" + i + ".txt");
				if (!temp.exists()) {
					saveNumber = i;
					break;
				}
			}
		System.out.println("saveFunction: " + cart);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(saves, "save" + saveNumber + ".txt")));
		oos.writeObject(cart);	
		oos.close();
		
		return saveNumber;
		
	}
	
	public static HashSet<Item> load(Integer saveNumber) throws FileNotFoundException, IOException {
		HashSet<Item> cart = null;

		File loc = new File(System.getenv("OSTORE_HOME") + "ShoppingCartSaves\\save" + saveNumber + ".txt");
		System.out.println("~~~~~~~~~~~~~~~~~Location: " + loc);
		System.out.println(loc.exists());
		if (loc.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loc));

			try {
				cart = (HashSet<Item>) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ois.close();
		}
		System.out.println(cart);
		return cart;
	}
	
	public static Double runningTotal(HashSet<Item> cart) {
		Double total = 0.0;
		if (cart != null)
			for (Item i : cart)
				total += i.getPrice();
		
		return total;
	}
	
}
