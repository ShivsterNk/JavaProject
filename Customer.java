
public class Customer extends User{

	public Customer(String username, String useremail) {
		
		super(username, useremail);
	}
	
	public void getUserType() {
		
		System.out.println("Role: Customer");
	}

}
