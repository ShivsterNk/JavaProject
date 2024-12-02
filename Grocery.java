
public class Grocery extends Product {

	private String expirationDate;
	
	public Grocery(String prodName, double prodPrice, int prodQuantity, String expirationDate) {
		
		super(prodName, prodPrice, prodQuantity);
		this.expirationDate = expirationDate;
	}
	
	public String getExpirationDate() {
		
		return expirationDate;
	}
	public String getCategory() {
		
		return "Grocery";
	}

}
