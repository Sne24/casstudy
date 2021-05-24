package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import com.cognizant.truyum.model.cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

@Override
	public void addCartItem(long userId, long menuItemId) {
	
		Connection con = ConnectionHandler.getConnection();
		String q = "insert into cart(userId,menuItemId) values (" + userId + "," + menuItemId + ")";
		try {
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

@Override
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

		cart cart = new cart( menuItemList,0);
		String q = "select * from MenuItems JOIN cart ON MenuItems.id = cart.menuItemId where cart.userId = "+ userId;
		try {
			PreparedStatement stmt = con.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			float value = 0.00f;
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				value = value + price;
				String active = rs.getString("active");
				Date date1 = rs.getDate("dateOfLaunch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("freeDelivery");
				boolean act = false;
				if (active.equalsIgnoreCase("yes")) {
					act = true;
				}
				boolean free = false;
				if (free_delivery.equalsIgnoreCase("yes")) {
					free = true;
				}
				MenuItem m1 = new MenuItem(id, name, category,price, act,  free,date1);
				menuItemList.add(m1);
			}
			cart.setTotal(value);
			cart.setMenuItemList(menuItemList);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return menuItemList;
	}

@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		String q = "delete from  cart where userId = "+userId+" AND menuItemId = "+menuItemId;
		try {
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}