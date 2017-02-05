package seedu.addressbook.data.person.address;

public class PostalCode {
	
	private int postalCode;
	
	public PostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	public int getPostalCode(){
		return this.postalCode;
	}
	
	public static boolean isValidPostalCode(int postalCode){
		return Integer.toString(postalCode).matches("[0-9]{6}");
	}
}
