package al.errvini.restaurantapp.model.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import al.errvini.restaurantapp.controller.order.AbstractOrderCalculator;
import al.errvini.restaurantapp.model.product.Meal;
import al.errvini.restaurantapp.model.product.Product;

public class AbstractOrderCalculatorTest {
	private AbstractOrderCalculator orderCalculatorTest = new AbstractOrderCalculator() {
		
		@Override
		public double getVatRate(boolean decimal) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public double calulateTotalOrderAmountVAT(double totalOrderAmount) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public double getVATRate() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public double getSizeRateAmount(OrderItemSize orderItemSize) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	@Test
		public void testCalculateTotalOrderAmount() {
		//Step1: Define the input/expectation
		double expectedTotalOrderAmount = 0;
		
		Product productTest = new Meal("Test-Burger", 100, 2, "tomato, pickles, ketchup" );
		OrderItem orderItemTest = new OrderItem(productTest, OrderItemSize.MEDIUM, 2);
			Order orderTest = new Order();
			orderTest.getOrderItems().add(orderItemTest);
			
			
			//Step 2: Execute method to test
			double totalOrderAmount = orderCalculatorTest.calculateTotalOrderAmount(orderTest);
			
			//Step3:Validate the result
			Assertions.assertEquals(expectedTotalOrderAmount, totalOrderAmount);
			
		}
	

}
