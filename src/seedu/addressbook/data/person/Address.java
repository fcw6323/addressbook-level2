package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.address.*;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    private static final int INDEX_BLOCK = 0;
    private static final int INDEX_STREET = 1;
    private static final int INDEX_UNIT = 2;
    private static final int INDEX_POSTALCODE = 3;

    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        splitAddressStringIntoComponents(trimmedAddress);
    }
    
    /**
     * Splits address into components e.g. Block, PostalCode
     * 
     */
    private void splitAddressStringIntoComponents(String value){
    	String[] strArr = value.split(",");
    	this.block = new Block(Integer.valueOf(strArr[INDEX_BLOCK].trim()));
    	this.street = new Street(strArr[INDEX_STREET].trim());
    	this.unit = new Unit(strArr[INDEX_UNIT].trim());
    	this.postalCode = new PostalCode(Integer.valueOf(strArr[INDEX_POSTALCODE].trim()));
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
    	//return value;
        return Integer.toString(this.block.getNumber()) + ", " + this.street.getStreet() + ", " + this.unit.getUnit() + ", " + Integer.toString(this.postalCode.getPostalCode());
    }

    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public int getBlock(){
    	return this.block.getNumber();
    }
    public String getStreet(){
    	return this.street.getStreet();
    }
    public String getUnit(){
    	return this.unit.getUnit();
    }
    public int getPostalCode(){
    	return this.postalCode.getPostalCode();
    }
}
