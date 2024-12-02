
public class Electronic extends Product {

	private String brand;
	
	public Electronic(String prodName, String brand, double prodPrice, int prodQuantity ) {
		
		super(prodName, prodPrice, prodQuantity);
		this.brand = brand;
	}
	
	public String getBrand() {
		
		return brand;
	}
	public String getCategory() {
		
		return "Electronic";
	}

}
