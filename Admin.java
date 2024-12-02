
public class Admin extends User {

	public Admin(String username, String useremail) {
		
		super(username, useremail);
	}
	
	public void getUserType() {
		
		System.out.println("Role: Customer");
	}

}
