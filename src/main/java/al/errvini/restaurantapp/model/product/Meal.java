package al.errvini.restaurantapp.model.product;

public class Meal extends Product {
	//Parent class(Product).....super class
	//Child class(meal).....subclass 
	private String description;
	
	public Meal(String name, int productId, double price, String description) {
		super(name, productId, price);
		this.description = description;
	}

	public Meal(String name, int productId, double price) {
		super(name, productId, price);
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}