package al.errvini.restaurantapp.model;

import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;

import al.errvini.restaurantapp.model.product.Drink;
import al.errvini.restaurantapp.model.product.Meal;
import al.errvini.restaurantapp.model.product.Product;

public class Menu {
	// HashMap<Key, Value>

	private HashMap<Integer, Product> menuItems = new HashMap<>();

	public Menu(boolean menuItemsFromFile) {
		if (!menuItemsFromFile) {
		

			initializeMenuItems();
		}
	}
	public Menu() {
		//initialize products in hashmap
		initializeMenuItems();
	}

	private void initializeMenuItems() {
		menuItems.put(100, new Meal("Burger", 100, 2, "tomato, pickles, ketchup"));
		menuItems.put(101, new Product("Cheeseburger", 101, 4));
		menuItems.put(102, new Product("Sandwich", 102, 1.5));
		menuItems.put(103, new Product("Hotdog", 103, 1.7));
		menuItems.put(104, new Product("Pizza", 104, 6));
		menuItems.put(105, new Product("Fries", 105, 2));
		menuItems.put(200, new Drink("Coca Cola", 200, 1, false));
		menuItems.put(201, new Drink("Coca Cola Zero", 201, 1, true));
		menuItems.put(202, new Product("Fanta", 202, 1));
		menuItems.put(203, new Product("Sprite", 203, 1));
		menuItems.put(204, new Product("Red Bull", 204, 2));
		menuItems.put(205, new Product("Coffee", 205, 0.5));
		menuItems.put(300, new Product("Ice cream", 300, 1));
		menuItems.put(301, new Product("Waffle", 301, 2.5));
		menuItems.put(302, new Product("Brownie", 302, 1.5));

		/*
		 * ArrayList<Product> products = new ArrayList<>(); products.add(new
		 * Product(null, 0, 0));
		 */

	}

	public HashMap<Integer, Product> getMenuItems() {
		return menuItems;

	}
}
