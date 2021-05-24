package com.cognizant.truyum.dao;

import java.util.*;
//import com.cognizant.truyum.model.cart;

public interface CartDao {

	public void addCartItem(long userId, long menuItemId);
	@SuppressWarnings("rawtypes")
	public ArrayList getAllCartItems(long userId) throws CartEmptyException;
	public void removeCartItem(long userId, long menuItemId);
	
}
