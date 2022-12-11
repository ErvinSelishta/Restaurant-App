package al.errvini.restaurantapp.model.order;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import al.errvini.restaurantapp.controller.menu.MenuImporter;
import al.errvini.restaurantapp.model.Menu;
import al.errvini.restaurantapp.model.product.Product;

public class MenuImporterTest {
	MenuImporter menuImporter = new MenuImporter();
	private final String MENU_FILE_PATH = "/pizza-menu.txt";

	@Test
	public void testImportMenu() {
		
		// Step 1 define input/expection
		//The input will be the menu file
		
		//Step 2 Execute method to test
		Menu menu = menuImporter.importMenu(MENU_FILE_PATH);
		HashMap<Integer, Product> menuItems = menu.getMenuItems();
		//Step 3 Validate the result
		Assertions.assertEquals(10, menuItems.size());
		
	}
}
