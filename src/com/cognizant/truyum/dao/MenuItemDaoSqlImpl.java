package com.cognizant.truyum.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cognizant.truyum.model.MenuItem;


public class MenuItemDaoSqlImpl implements MenuItemDao {

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemlist = new ArrayList<MenuItem>();
		Connection con = ConnectionHandler.getConnection();
		ResultSet res = null;
		final String q="select * from MenuItems";
		try {

			PreparedStatement stmt = con.prepareStatement(q);
			res = stmt.executeQuery();
			while (res.next()) {
				long id = res.getLong("id");
				String name = res.getString("name");
				float price = res.getFloat("price");
				String active = res.getString("active");
				Date date1 = res.getDate("dateOfLaunch");
				String category = res.getString("category");
				String free_delivery = res.getString("freeDelivery");
				boolean a = false;
				if (active.equalsIgnoreCase("yes")) {
					a = true;
				}
				boolean fd = false;
				if (free_delivery.equalsIgnoreCase("yes")) {
					fd = true;
				}
				MenuItem m1 = new MenuItem(id, name, category,price, a, fd, date1);
				menuItemlist.add(m1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return menuItemlist;

}

@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {

		ArrayList<MenuItem> menuItemListCust = new ArrayList<MenuItem>();
		Connection con = ConnectionHandler.getConnection();
		final String q = "select * from MenuItems where active='Yes' AND dateOfLaunch < '2021-05-20'";
		try {

			PreparedStatement stmt = con.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String active = rs.getString("active");
				Date date1 = rs.getDate("dateOfLaunch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("freeDelivery");
				boolean a = false;
				if (active.equalsIgnoreCase("yes")) {
					a = true;
				}
				boolean fd = false;
				if (free_delivery.equalsIgnoreCase("yes")) {
					fd = true;
				}
				MenuItem m1 = new MenuItem(id, name, category,price, a,  fd,date1);
				menuItemListCust.add(m1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return menuItemListCust;

	}

@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();
		long id = menuItem.getId();
		String name = menuItem.getName();
		float price = menuItem.getPrice();
		boolean active = menuItem.isActive();

		Date d = new Date(menuItem.getDateOfLaunch().getTime());
		String category = menuItem.getCategory();
		boolean free = menuItem.isFreeDelivery();
		String a;
		if (active == true) {
			a = "Yes";
		} else {
			a = "No";
		}
		String fd;
		if (free == true) {
			fd = "Yes";
		} else {
			fd = "No";
		}
		final String q = "update MenuItems" + "name = " + name + ",price = " + price + " active = "+ a + ",dateOfLaunch = "+ d +",category = "+ category +",freeDelivery = "+ fd + "where id = "+id;
		try {
			PreparedStatement stmt = con.prepareStatement(q);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


@Override
	public MenuItem getMenuItem(long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
	
		final String query = "select * from MenuItems where id= " + menuItemId;
		MenuItem m = null;
		try {

			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
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
				m = new MenuItem(id, name, category,price, act,  free,date1 );

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return m;
	}
}