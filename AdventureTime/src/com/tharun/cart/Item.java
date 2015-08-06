package com.tharun.cart;

import java.io.Serializable;
import java.util.HashSet;

public class Item implements Serializable{
	private String name;
	private double price;
	private String description;
	private String imageLoc;
	private int id;
	private HashSet<String> imageLocs;
	
	public Item(String name, int id, double price, String description, String imageLoc, HashSet<String> imageLocs) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageLoc = imageLoc;
		this.id = id;
		this.imageLocs = imageLocs;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public String getImageLoc() {
		return imageLoc;
	}
	public int getId() {
		return id;
	}
	
	public HashSet<String> getImageLocs() {
		return imageLocs;
	}
	
	public String getShortDescription() {
		if (description.length() > 101)
			return description.substring(0, 100) + (description.length() > 100 ? "..." : "");
		else
			return description;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
