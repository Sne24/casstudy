package com.cognizant.truyum.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class cart {
	
	private ArrayList<MenuItem> menuItemList;
	private double total;
	//Writing getters and setters for the attributes created
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total=total;
	}
	public ArrayList<MenuItem> getMenuItemList(){
		return menuItemList;
	}
	public void setMenuItemList(ArrayList<MenuItem> menuItemList){
		this.menuItemList=menuItemList;
	}
	
	//Parametrized constructor
	public cart(ArrayList<MenuItem> menuItemList,double total) {
		this.menuItemList=menuItemList;
		this.total=total;
	}
	
	public cart(){}
	
	
}
