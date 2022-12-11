package al.errvini.restaurantapp.model.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import al.errvini.restaurantapp.controller.order.OrderCalculatorAL;

public class OrderCalculatorALTest {

	// Creating the object of the class to test
	OrderCalculatorAL orderCalculatorTest = new OrderCalculatorAL();

//Definition of the first test method
	@Test
	public void testGetVATRate() {

		// Step 1 define input/expection
		double expectedVATRate = 0.2;

		//Step 2 Execute method to test
		double vatRate = orderCalculatorTest.getVATRate();
//System.out.println("Vat Rate : " + vatRate);
		
		
		
//Step 3 Validate the result
		Assertions.assertEquals(expectedVATRate, vatRate);

	}

	@Test
	public void testGetSizeRateAmount() {

		double sizeRateAmountForSmallSize = orderCalculatorTest.getSizeRateAmount(OrderItemSize.SMALL);
		Assertions.assertEquals(0.7, sizeRateAmountForSmallSize);
	}
}