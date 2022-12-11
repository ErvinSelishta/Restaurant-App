package al.errvini.restaurantapp;
//Define the main method to start Java application

import java.util.Scanner;

import al.errvini.restaurantapp.controller.LocationManager;
import al.errvini.restaurantapp.controller.menu.MenuPrinter;
import al.errvini.restaurantapp.controller.order.AbstractOrderCalculator;
import al.errvini.restaurantapp.controller.order.OrderAmount;
import al.errvini.restaurantapp.controller.order.OrderCalculatorAL;
import al.errvini.restaurantapp.controller.order.OrderCalculatorGER;
import al.errvini.restaurantapp.controller.order.OrderManager;
import al.errvini.restaurantapp.controller.order.OrderPrinter;
import al.errvini.restaurantapp.model.ApplicationMode;
import al.errvini.restaurantapp.model.Client;
import al.errvini.restaurantapp.model.Location;
import al.errvini.restaurantapp.model.Menu;
import al.errvini.restaurantapp.model.Restaurant;
import al.errvini.restaurantapp.model.order.Order;

//Signature of a method: <modifier> <return-type> <method-name> (<parameters>) {}
//Java shortcuts
// Dublicate lines CTRL ALT arrow up / down
// move lines ALT Arrow up/down
// Shift Alt R refactor rename
// Delete lines CTRL D

// Create an object of a restaurant
// Type object-name= new type(); ----> (Constructor)
// Object.atributes / Object methods
// Break point
/* Debugger keys -F5 Step into -F6 Step over -F7 Step out -F8 Step next */

public class RestaurantApp {
	private static Location currentLocation;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		currentLocation = getCurrentLocation();

		ApplicationMode applicationMode = getApplicationMode();
		validateApplicationMode(applicationMode);

	}

	private static void validateApplicationMode(ApplicationMode applicationMode) {
		switch (applicationMode) {

		case ORDER:
			runOrderProcess();
			break;

		case TABLE_RESERVATION:
			runTableReservationProcess();
			break;
		default:
			throw new IllegalArgumentException(
					"No valid application mode selected! Application mode does not support " + applicationMode);
		}
	}

	private static Location getCurrentLocation() {

		System.out.println("Please enter a location: ");

		int locationID = scanner.nextInt();

		switch (locationID) {
		case 1:
			return Location.GERMANY;

		case 2:
			return Location.ALBANIA;

		default:
			throw new IllegalArgumentException(
					"No valid application mode selected! Application mode does not support " + locationID);

		}

	}

	private static ApplicationMode getApplicationMode() {
		System.out.println("Please enter an application mode: ");
		int applicationModeID = scanner.nextInt();
		if (applicationModeID == 1) {
			return ApplicationMode.ORDER;
		} else if (applicationModeID == 2) {
			return ApplicationMode.TABLE_RESERVATION;
		} else {

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("The selected application mode id: ");
			stringBuilder.append(applicationModeID);
			stringBuilder.append(" is not supported. Valid application modes: [1,2]");
			throw new IllegalArgumentException(stringBuilder.toString());

		}

	}

	private static void runOrderProcess() {

		Restaurant restaurant = new Restaurant("Nena Dashuri Agroturizem", " Peshkopi ");
		Client client = new Client("Ervin Selishta", " +355672553016 ", " Rruga e llixhave ", "8301");

		// SHow the menu
		Menu menu = new Menu();
		MenuPrinter menuPrinter = new MenuPrinter();
		menuPrinter.printMenu(menu);

		OrderManager orderManager = new OrderManager();

		Order order1 = orderManager.createOrder(menu);
		Order order2 = new Order();
		Order order3 = new Order();
		Order order4 = new Order();
		Order order5 = new Order();

		orderManager.addOrder(order1);
		orderManager.addOrder(order2);
		orderManager.addOrder(order3);
		orderManager.addOrder(order4);
		orderManager.addOrder(order5);

		// Dynamic load appopriate based on the location

		AbstractOrderCalculator orderCalculator = getOrderCalculator();

		OrderAmount orderAmount = orderCalculator.calculateOrderAmount(order1);

		OrderPrinter orderPrinter = new OrderPrinter();
		orderPrinter.printOrderInfo(order1, restaurant, client, orderAmount, orderCalculator.getVATRate(false));

	}

	private static AbstractOrderCalculator getOrderCalculator() {
		switch (currentLocation) {
		case ALBANIA:
			return new OrderCalculatorAL();
		case GERMANY:
			return new OrderCalculatorGER();

		}

		System.err.println("");
		return null;
	}

	private static void runTableReservationProcess() {
		System.out.println("The selected table no 4 was reserved successffuly ");

	}

}
