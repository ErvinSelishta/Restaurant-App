package al.errvini.restaurantapp.controller.menu;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import al.errvini.restaurantapp.model.Menu;
import al.errvini.restaurantapp.model.product.Drink;
import al.errvini.restaurantapp.model.product.Meal;
import al.errvini.restaurantapp.model.product.Product;

public class MenuImporter {
	public Menu importMenu(String filePath) {
		Menu importedMenu = new Menu(true);

		try {
			// find and read the file
			List<String> readAllLines = Files.readAllLines(Paths.get(getClass().getResource(filePath).toURI()));
			// get the information from each line/menu item as String
			for (String menuItemAsString : readAllLines) {
				// get the information from each splitted string value
				String[] menuItemAsStringArray = menuItemAsString.split(",");

				// Transform file information to Product object
				int productId = Integer.valueOf(menuItemAsStringArray[0]);
				String productName = menuItemAsStringArray[1];
				double productPrice = Double.valueOf(menuItemAsStringArray[2]);
				String productCategory = menuItemAsStringArray[3];
				Product product = null;
				if ("meal".equals(productCategory)) {

					product = new Meal(productName, productId, productPrice);

				} else if ("drink".equals(productCategory)) {
					boolean sugarFree = Boolean.valueOf(menuItemAsStringArray[4]);
					product = new Drink(productName, productId, productPrice, sugarFree);
				} else {
					StringBuffer stringBuffer = new StringBuffer();
					stringBuffer.append("The menu file could not be proccesed as the product category from product");
					stringBuffer.append(productName).append("is invalid. ");

				}
				importedMenu.getMenuItems().put(productId, product);
			}
			
		} catch (IOException e) {
			throw new RuntimeException("Menu file could not be found. ", e);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return importedMenu;
	}
}
