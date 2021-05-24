package com.cognizant.truyum.dao;
import com.cognizant.truyum.util.DateUtil;
import java.util.*;
import java.util.ArrayList;
import com.cognizant.truyum.model.MenuItem;


public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static ArrayList<MenuItem> menuItemList;
	MenuItemDaoCollectionImpl() throws Exception{
		super();
		if(menuItemList == null || menuItemList.isEmpty()) {
			
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem( 01, "Sandwich", "Main Course", 99.0f,true,true,DateUtil.convertToDate("15/03/2017")));
			menuItemList.add(new MenuItem( 02, "Burger", "Main Course", 129.0f,true,false,DateUtil.convertToDate("23/12/2017")));
			menuItemList.add(new MenuItem( 03, "Pizza", "Main Course", 149.0f,true,false,DateUtil.convertToDate("21/08/2018")));
			menuItemList.add(new MenuItem( 04, "French Fries", "Starters", 57.0f,false,true,DateUtil.convertToDate("02/07/2017")));
			menuItemList.add(new MenuItem( 05, "Chocolate Brownie", "Dessert", 32.0f,true,true,DateUtil.convertToDate("02/11/2022")));
		}
	}
	
	public ArrayList<MenuItem> getMenuItemListAdmin() {
		
		return menuItemList;
	}
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		
		ArrayList<MenuItem> a=new ArrayList<MenuItem>();
		for(MenuItem x:menuItemList) {
			
			Date d=x.getDateOfLaunch();
			String tdy="19/05/2021";
			Date tdate = DateUtil.convertToDate(tdy);
			if(d.before(tdate) || d.equals(tdate)) {
				
				if(x.isActive()) {
					a.add(x);
				}
			}
		}
		return a;
	}
	public void modifyMenuItem(MenuItem menuItem) {
		for(MenuItem x: menuItemList) {
			if(x.equals(menuItem)) {
				 
				x.setName(menuItem.getName());
				x.setActive(menuItem.isActive());
				x.setCategory(menuItem.getCategory());
				x.setDateOfLaunch(menuItem.getDateOfLaunch());
				x.setFreeDelivery(menuItem.isFreeDelivery());
				
				
			}
		}
	}
	public MenuItem getMenuItem(long menuItemId) {
		for(MenuItem x: menuItemList) {
			
			if(x.getId()==menuItemId) {
				
				return x;
			}
		}
		return null;
	}

	

}
