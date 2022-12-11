package al.errvini.restaurantapp.controller.menu;

import java.util.HashMap;
import java.util.Map.Entry;

import al.errvini.restaurantapp.model.Menu;
import al.errvini.restaurantapp.model.product.Product;

public class MenuPrinter {
	public void printMenu(Menu menu) {
		System.out.println("-------------------Menu--------------------");
		// for each applied on a hashmap

		HashMap<Integer, Product> menuItems = menu.getMenuItems();

		for (Entry<Integer, Product> menuEntry : menuItems.entrySet()) {
			Product menuItem = menuEntry.getValue();
			System.out.println(menuItem.getProductId() + " . " + menuItem.getName() + " | " + menuItem.getPrice() + " Euro");
			}
		System.out.println("-------------------------------------------------");
	}
}
