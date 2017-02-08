package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;


public class Contact {
	public final String value;
	private boolean isPrivate;
	
	public Contact(String contact, boolean isPrivate, String errorMessage, String validRegex) throws IllegalValueException {
		this.value = contact.trim();
		this.isPrivate = isPrivate;
		if(!isValidContact(validRegex)){
			throw new IllegalValueException(errorMessage);
		}
	}
	
	/**
	 * returns true if this.value matches regex
	 * @param regex
	 * @return
	 */
	private boolean isValidContact(String regex){
		return this.value.matches(regex);
	}
	
	public boolean isPrivate(){
		return isPrivate;
	}

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
