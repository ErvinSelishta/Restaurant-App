package al.errvini.restaurantapp.model.order;

import java.util.ArrayList;

import al.errvini.restaurantapp.model.product.Product;

public class Order {

	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

}
