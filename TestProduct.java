import java.util.List;
import java.util.stream.Collectors;

public class TestProduct {
	
	public static void main(String[] args) {

		Product pants = new Clothing("Ripped Jeans", "28", 36.0, 1);
		Product hoodie = new Clothing("Tie-dye Hoddie", "Large", 24.0, 1);
		Product cupcakes = new Grocery("Red Velvet Cupcakes", 15.0, 2, "02/04/2025");
		Product platter = new Grocery("Orange Juice", 12.0, 1, "3/29/2025");
		Product headphones = new Electronic("Galaxy Buds 3 Pro", "Samsung", 149.0, 1);
		Product soundbar = new Electronic("TV Soundbar", "Sony", 299.0, 1);
		
		User customer = new Customer("Kyle Marsh", "marshk@email.com");
		User admin = new Admin("Angela Thomas", "thomasa@email.com");
		
		Order custOrder = new Order(customer);
		custOrder.addProduct(soundbar);
		custOrder.addProduct(cupcakes);
		custOrder.addProduct(pants);
		
		Order adminOrder = new Order(admin);
		adminOrder.addProduct(headphones);
		adminOrder.addProduct(platter);
		adminOrder.addProduct(hoodie);
		
		System.out.println("Customer's Order - Sort By Name: ");
		List<Product> sortedCustomerProds = custOrder.sortProdByName(null);
		sortedCustomerProds.forEach( products -> System.out.println(products.getProdName() 
				+ " - $" + products.getProdPrice()));
		
		System.out.println("\nCustomer Order - Search By Name ->");
		String search = "TV";
		List<Product> searchByName = searchByName(custOrder.getProducts(), search);
		searchByName.forEach( products -> System.out.println(products.getProdName()
				+ " - $" + products.getProdPrice()));
		
		System.out.println();
		
	    // Checkout for customer
	    custOrder.checkout();
	    
	    System.out.println("\n***************************************************************\n");
	    
	    System.out.println("Admin's Order - Sort By Name: ");
		List<Product> sortedAdminProds = adminOrder.sortProdByName(null);
		sortedAdminProds.forEach( products -> System.out.println(products.getProdName() 
				+ " - $" + products.getProdPrice()));
	
	    System.out.println();
	
	      // Checkout for admin
	    adminOrder.checkout();
	}
	
	public static List<Product> searchByName(List<Product> products, String prodName) {
	    	return products.stream().filter( product -> product.getProdName()
	    			.toLowerCase().contains(prodName.toLowerCase()))
	    			.collect(Collectors.toList());
	}
	
}
