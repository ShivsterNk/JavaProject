
public abstract class User {

	private String username;
	private String useremail;
	
	public User(String username, String useremail) {
		
		this.username = username;
		this.useremail = useremail;

	}
	
	public String getUsername() {
		
		return this.username;
	}
	
	public String getUseremail() {
		
		return this.useremail;
	}
	
	public abstract void getUserType();

}
