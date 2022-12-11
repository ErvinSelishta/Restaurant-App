package al.errvini.restaurantapp.model.product;

public class Drink extends Product {

	private boolean sugarFree;
	
	public Drink(String name, int productId, double price) {
		super(name, productId, price);
	}
	
		public Drink(String name, int productId, double price, boolean sugarFree) {
			super(name, productId, price);
			this.sugarFree = sugarFree;
		}

		public boolean isSugarFree() {
			return sugarFree;
		}

		public void setSugarFree(boolean sugarFree) {
			this.sugarFree = sugarFree;
		}
		

}
