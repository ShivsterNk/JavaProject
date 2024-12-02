
public class Clothing extends Product {

	private String size;
	
	public Clothing(String prodName, String size, double prodPrice, int prodQuantity) {
		
		super(prodName, prodPrice, prodQuantity);
		this.size = size;
	}
	
	public String getSize() {
		
		return size;
	}
	
	public String getCategory() {
		
		return "Clothing";
	}
}
