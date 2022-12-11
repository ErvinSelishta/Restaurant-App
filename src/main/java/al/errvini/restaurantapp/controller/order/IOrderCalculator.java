package al.errvini.restaurantapp.controller.order;

import al.errvini.restaurantapp.model.order.Order;
import al.errvini.restaurantapp.model.order.OrderItem;
import al.errvini.restaurantapp.model.order.OrderItemSize;

//Interfaces are used do define contracts
public interface IOrderCalculator {
	public double calculateTotalOrderAmount(Order order);
	public OrderAmount calculateOrderAmount(Order order);
	public double calculateOrderItemPrice(OrderItem orderItem);
	public double getSizeRateAmount(OrderItemSize orderItemSize);
	public double calulateTotalOrderAmountVAT(double totalOrderAmount);
	
	public double getVatRate(boolean decimal);

}