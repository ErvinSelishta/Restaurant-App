package al.errvini.restaurantapp.controller.order;

import java.util.ArrayList;

import al.errvini.restaurantapp.model.Client;
import al.errvini.restaurantapp.model.Restaurant;
import al.errvini.restaurantapp.model.order.Order;
import al.errvini.restaurantapp.model.order.OrderItem;

public class OrderPrinter {
	public void printOrderInfo(Order order, Restaurant restaurant, Client client, OrderAmount orderAmount, double vatRate) {

		System.out.println("Order from " + client.getName() + " (" + client.getAddress() + ")");
		// SysoutCTRL space
		System.out.println("Phone Number" + client.getPhoneNo());

		System.out.println("------------------------------------------------");

		ArrayList<OrderItem> orderItems = order.getOrderItems();

		for (OrderItem orderItem : orderItems) {
			
			double totalOrderItemPrice = orderItem.getOrderItemPrice() * orderItem.getQuantity();

			System.out.println(orderItem.getQuantity() + "x " + orderItem.getProduct().getName() + " | "
					+ orderItem.getOrderItemPrice() + " | " + totalOrderItemPrice + " Euro ");

		}

		System.out.println("------------------------------------------------");
		System.out.println("Total Amount:           " + orderAmount.getTotalOrderAmount() + " Euro ");
	                
		System.out.println("VAT:  " + vatRate + " %             "+ orderAmount.getTotalOrderAmountVAT() + " Euro ");
		System.out.println("------------------------------------------------");
		System.out.println("Total Amount with VAT  " + orderAmount.getTotalOrderAmountWithVAT() + " Euro ");

		System.out.println("------------------------------------------------");
		System.out.println(restaurant.getName() + " in" + restaurant.getAddress());

		/*
		 * System.out.println("Klienti " + client.getName() + " ka porositur " +
		 * order.getProduct1().getName() + ", nje " + order.getProduct2().getName() +
		 * " , 3 " + order.getProduct3().getName() + " dhe 4 " +
		 * order.getProduct4().getName() + " tek " + restaurant.getName() + " ne " +
		 * restaurant.getAddress() + ". ");
		 */

	}
}
