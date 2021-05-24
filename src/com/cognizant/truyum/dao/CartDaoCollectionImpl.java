package com.cognizant.truyum.dao;

import java.util.*;
import com.cognizant.truyum.model.cart;
import com.cognizant.truyum.model.MenuItem;


public class CartDaoCollectionImpl implements CartDao{
	
	private static HashMap<Long,cart> userCarts;
	public CartDaoCollectionImpl() {
		
		if(userCarts == null) {
			
			userCarts = new HashMap<Long,cart>();
		}
		
	}
	
	
	@Override
	public void addCartItem(long userId, long menuItemId) {
		
		try {
			
			MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
			MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
			if(userCarts.containsKey(userId)) {
				ArrayList<MenuItem> cartItems = userCarts.get(userId).getMenuItemList();
				cartItems.add(menuItem);
				//userCarts.get(userId).setMenuItemList(cartItems);
			}
			else {
				
				ArrayList<MenuItem> cartMenu = new ArrayList<MenuItem>();
				cartMenu.add(menuItem);
				//change in arg order
				cart newc = new cart(cartMenu,0.0);
				userCarts.put(userId, newc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}   
	}
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		
		ArrayList<MenuItem> getAll = userCarts.get(userId).getMenuItemList();
		/*if(getAll.isEmpty()) {
			
			throw new CartEmptyException();
		}*/
		
			double val = 0.0;
			for(MenuItem x:getAll) {
				
				val += x.getPrice();
			}
			userCarts.get(userId).setTotal(val);
		
		//System.out.println(userCarts);
		return getAll;
	}
	
	@Override
	public void removeCartItem(long userId, long menuItemId){
		
		ArrayList<MenuItem> removeList = userCarts.get(userId).getMenuItemList();
		for(MenuItem x: removeList) {
			
				if(x.getId() == menuItemId) {
				
					removeList.remove(removeList.indexOf(x));
					break;
					
				}
			
		}
		
		userCarts.get(userId).setMenuItemList(removeList);
	}

	
}
