package al.errvini.restaurantapp.controller.order;

import java.util.ArrayList;

import al.errvini.restaurantapp.exception.InvalidOrderItemSizeException;
import al.errvini.restaurantapp.model.order.Order;
import al.errvini.restaurantapp.model.order.OrderItem;
import al.errvini.restaurantapp.model.order.OrderItemSize;
import al.errvini.restaurantapp.model.product.Product;

public abstract class AbstractOrderCalculator implements IOrderCalculator {

	public double getVATRate(boolean decimal) {
		if (decimal) {
			return getVATRate();
		} else {
			return getVATRate() * 100;
		}

	}

	public double calculateTotalOrderAmount(Order order) {

		ArrayList<OrderItem> orderItems = order.getOrderItems();

		double totalOrderAmount = 0.0;

		for (OrderItem orderItem : orderItems) {

			totalOrderAmount += calculateOrderItemPrice(orderItem);
		}
		return totalOrderAmount;
	}

	public double calculateOrderItemPrice(OrderItem orderItem) {
		double sizeRateAmount = 1;
		try {
			 sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
			
		}catch(InvalidOrderItemSizeException e) {
			System.err.println("No valid order item size for item : " + orderItem.getProduct().getName());
				
			}
		


		Product product = orderItem.getProduct();

		double totalOrderItemPrice = product.getPrice() * sizeRateAmount;
		orderItem.setOrderItemPrice(totalOrderItemPrice);
		return totalOrderItemPrice * orderItem.getQuantity();

	}

	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {

		return totalOrderAmount * getVATRate();

	}

	public OrderAmount calculateOrderAmount(Order order) {
		double totalOrderAmount = calculateTotalOrderAmount(order);
		double totalOrderAmountVAT = calculateTotalOrderAmountVAT(totalOrderAmount);
		double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT;
		OrderAmount orderAmount = new OrderAmount(totalOrderAmount, totalOrderAmountVAT, totalOrderAmountWithVAT);
		return orderAmount;
	}

	public abstract double getSizeRateAmount(OrderItemSize orderItemSize);

	public abstract double getVATRate();

}
