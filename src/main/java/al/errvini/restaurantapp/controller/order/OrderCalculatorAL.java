package al.errvini.restaurantapp.controller.order;





import al.errvini.restaurantapp.exception.InvalidOrderItemSizeException;

/**
 * Order calculator for Albania.
 * @author Ervin Selishta
 */

import al.errvini.restaurantapp.model.order.OrderItemSize;

public class OrderCalculatorAL extends AbstractOrderCalculator {
	private final double VAT_RATE = 0.20;

	public double getSizeRateAmount(OrderItemSize orderItemSize) {

		// using inum with switch case

		switch (orderItemSize) {

		case SMALL:
			// 30% discount from standart price
			return 0.7;
		// no discount per standart price
		case MEDIUM:
			return 1.0;

		// 20% in addition for large size
		case LARGE:
			return 1.2;
		// 25% in additio per XXL size
		case XXL:
			return 1.25;

		default:
			throw new InvalidOrderItemSizeException("No valid order item size : " + orderItemSize);
			//System.err.println("No valid order item size : " + orderItemSize);
			//return 1;

		}

	}

	@Override
	public double getVatRate(boolean decimal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getVATRate() {
		// TODO Auto-generated method stub
		return VAT_RATE;
	}

	@Override
	public double calulateTotalOrderAmountVAT(double totalOrderAmount) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

	

	
	

	
	



	


	

	
	

	
	
}
