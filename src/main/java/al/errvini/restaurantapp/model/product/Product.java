
package al.errvini.restaurantapp.model.product;

public class Product {
	private String name;
	private int productId;
	private double price;

	public Product(String name, int productId, double price) {
		this.name = name;
		this.productId = productId;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//Format code   CTRL SHIFT F ose SHIFT ALTF

}
