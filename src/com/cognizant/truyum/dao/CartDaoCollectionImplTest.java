package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;
import java.util.*;


public class CartDaoCollectionImplTest {
	
	@SuppressWarnings("unchecked")
	public static void testAddCartItem() {
		
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1,1);
		cartDao.addCartItem(1,2);
		cartDao.addCartItem(1,3);
		cartDao.addCartItem(1,4);
		
		try {
			
			ArrayList<MenuItem> cartList = cartDao.getAllCartItems(1);
			System.out.println("items added to cart successfuly");
			//System.out.println(userId);
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));

			for (MenuItem item : cartList) {

				//System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
				System.out.println(item.toString());
			}
			
		}
		catch(CartEmptyException e) {
			
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	public static void testGetAllCartItems()
	{
		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			
			ArrayList<MenuItem> cartItems = cartDao.getAllCartItems(1);
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));
			for(MenuItem item:cartItems)
			{
				
				//System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
				System.out.println(item.toString());
			}
		}
		catch(CartEmptyException e) {
			
			e.printStackTrace();
		}

		
	}
	@SuppressWarnings("unchecked")
	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1,2);
		try
		{
			ArrayList<MenuItem> cartLefts = cartDao.getAllCartItems(1); 
			
				for(MenuItem item:cartLefts)
				{
					
					//System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
					System.out.println(item.toString());
				}
 
		}
		catch(CartEmptyException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		testAddCartItem();
		//testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		
	}

	
}
