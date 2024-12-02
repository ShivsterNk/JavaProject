import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Order {

	private List<Product> products;
	private User user;
	
	public Order(User user) {
        this.products = new ArrayList<>();
        this.user = user;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
    
    public List<Product> getProducts() {
    	return products;
    }
    
    //Filters product stream/list out by Category, ignoring spelling
    public List<Product> filterProdByCatg(String category) {
    	Predicate<Product> filter = p -> p.getCategory().equalsIgnoreCase(category);
    	return products.stream().filter(filter).collect(Collectors.toList());
    }
   
    //Sorts product stream/list by Alphabetical Order
    public List<Product> sortProdByName(String prodName) {
    	return products.stream().sorted((p1, p2) -> p1.getProdName().
    			compareToIgnoreCase(p2.getProdName())).collect(Collectors.toList());
    }
    
    //Calculate total price before all conditions are applied
    public double calcPrice() {
    	return products.stream().mapToDouble(product -> product.getProdPrice() 
    			* product.getProdQuantity()).sum();
    }
    
    //Applies 25% Discount for Admin, 10% for Customer
    public double applyDiscount() {
    	double total = calcPrice();
    	Function<Double, Double> discountFunction = user instanceof Admin
    			? price -> price * 0.75
    			: price -> price * 0.90;
    	return discountFunction.apply(total);
    }
    
    //Sets Tax Amount
    public double applyTax(double taxAmt) {
    	return applyDiscount() * (1 + taxAmt);
    }
    
    //If products brought is more than 3, free shipping. If not, 10 dollar ship rate.
    public double shippingRate() {
    	return products.size() > 3 ? 0.0 : 10.0;
    }
    
    //Monitors the price before/after discount, tax, shipping, and displays messages. 
    public void checkout() {
    	double totalNoDisc = calcPrice();
    	double discount = applyDiscount();
    	double tax = applyTax(0.05); //5% Tax Rate
    	double shipping = shippingRate();
    	
    	System.out.println("Checkout for: " + user.getUseremail());
    	System.out.println("Total: $" + totalNoDisc);
    	System.out.println("Total after Discount: $" + discount);
    	System.out.println("Total after Tax: $" + tax);
    	if (shipping == 0.0) {
            System.out.println("Shipping: Free");
        } 
    	else {
            System.out.println("Shipping: $10");
        }
    	
    	System.out.println("Your Total for your entire purchase is: $" + (tax + shipping));
    }
    
}
