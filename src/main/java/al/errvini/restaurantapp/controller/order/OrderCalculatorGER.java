package al.errvini.restaurantapp.controller.order;



import al.errvini.restaurantapp.exception.InvalidOrderItemSizeException;

/**
 * Order calculator for Albania.
 * @author Ervin Selishta
 */

import al.errvini.restaurantapp.model.order.OrderItemSize;


public class OrderCalculatorGER extends AbstractOrderCalculator  {
private final double VAT_RATE = 0.19;
	

	public double getSizeRateAmount(OrderItemSize orderItemSize)  {
		
		//using inum with switch case
		
		switch(orderItemSize) {
		
		case SMALL:
		//20% discount from standart price
			return 0.8;
			//no discount per standart price
		case MEDIUM:
			return 1.0;
			
			//25% in addition for large size
		case LARGE :
			return 1.25;
			//30% in additio per XXL size
		case XXL :
			return 1.3;
			
			
		default:
			throw new InvalidOrderItemSizeException("No valid order item size : " + orderItemSize);
			//System.err.println("No valid order item size : " + orderItemSize);
			//return 1;
			
		}

		
	}


	@Override
	public double calulateTotalOrderAmountVAT(double totalOrderAmount) {
		// TODO Auto-generated method stub
		return 0;
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



	

}
