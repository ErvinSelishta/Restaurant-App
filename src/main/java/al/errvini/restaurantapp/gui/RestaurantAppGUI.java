package al.errvini.restaurantapp.gui;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import al.errvini.restaurantapp.model.Menu;
import al.errvini.restaurantapp.model.product.Product;

public class RestaurantAppGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantAppGUI window = new RestaurantAppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RestaurantAppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel applicationNameLabel = new JLabel("Restaurant App (ErvinSelishta)");
		applicationNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(applicationNameLabel);

		String[][] preparedMenuDataTable = prepareMenuDataTable();
		String[] tableHeader = { "ID", "Name", "Price" };

		DefaultTableModel menuItemTableModel = new DefaultTableModel();
		menuItemTableModel.setDataVector(preparedMenuDataTable, tableHeader);
		JTable menuDataTable = new JTable(menuItemTableModel);
		JScrollPane scrollPane = new JScrollPane(menuDataTable);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Restaurant Menu"));
		frame.getContentPane().add(scrollPane);

	}

	private String[][] prepareMenuDataTable() {
		Menu menu = new Menu();
		String[][] menuItemListMultidimensionalArray = createMenuItemListArray(menu);
		return menuItemListMultidimensionalArray;

	}

	private String[][] createMenuItemListArray(Menu menu) {
		HashMap<Integer, Product> menuItems = menu.getMenuItems();
		String[][] menuItemListMultidimensionalArray = new String[menuItems.size()][3];
		int i = 0;
		for (Entry<Integer, Product> menuItem : menuItems.entrySet()) {

			Product product = menuItem.getValue();
			menuItemListMultidimensionalArray[i][0] = Integer.toString(product.getProductId());
			menuItemListMultidimensionalArray[i][1] = product.getName();
			menuItemListMultidimensionalArray[i][2] = Double.toString(product.getPrice());
			i++;
		}

		return menuItemListMultidimensionalArray;
	}

}
