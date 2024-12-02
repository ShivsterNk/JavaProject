
public abstract class Product {

	private String prodName;
	private double prodPrice;
	private int prodQuantity;
	
	public Product(String prodName, double prodPrice, int prodQuantity) {
		
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
	}
	
	public String getProdName() {
		
		return this.prodName;
	}
	
	public double getProdPrice() {
		
		return this.prodPrice;
	}
	
	public int getProdQuantity() {
		
		return this.prodQuantity;
	}
	
	public abstract String getCategory();

}
