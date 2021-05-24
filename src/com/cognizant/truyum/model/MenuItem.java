package com.cognizant.truyum.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MenuItem {
	private  long id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;
	public long getId() {
		return id;
	}
	//Writing getter and setter functions for the attributes
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public String getCategory() {
		return category;
	}
	public void setId(long id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(float price) {
		this.price=price;
	}
	public void setCategory(String category) {
		this.category=category;
	}
	public boolean isActive() {
		// TODO Auto-generated method stub
		return active;
	}
	public void setActive(boolean active) {
		// TODO Auto-generated method stub
		this.active=active;
	}
	public boolean isFreeDelivery() {
		// TODO Auto-generated method stub
		return freeDelivery;
	}
	public void setFreeDelivery(boolean freeDelivery) {
		// TODO Auto-generated method stub
		this.freeDelivery=freeDelivery;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		// TODO Auto-generated method stub
		this.dateOfLaunch = dateOfLaunch;
		
	}
	
	//Parametrized constructor for class
	public MenuItem(long id, String name, String category, float price, boolean active, boolean freeDelivery, Date dateOfLaunch) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.category=category;
		this.freeDelivery=freeDelivery;
		this.active=active;
		this.dateOfLaunch=dateOfLaunch;
	}
	
	public boolean equals(MenuItem obj) {
		if(obj instanceof MenuItem) {
			MenuItem m=(MenuItem)obj;
			return(this.id==m.id);
		}
		return false;
	}
	public String toString() {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",name,price,active,df.format(dateOfLaunch),category,freeDelivery);
	}
	
}

