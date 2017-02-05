package seedu.addressbook.data.person.address;
import java.util.regex.*;

/**
 * 
 * @author CHUAN
 * Block number can contain an alphabet at the back.
 */
public class Block {
	
	private String number;
	
	public Block(String number) {
		this.number = number;
	}
	
	public String getNumber(){
		return number;
	}
	/**
	 * Regex
	 * \b\d{1,3}[A-Z]{0,1}\b
	 * matches any valid block number with 1-4 digits followed by 0 or 1 alphabet.
	 * @param number
	 * @return
	 */
	public static boolean isValidBlockNumber(String blockNumber){
		Pattern p = Pattern.compile("\\b\\d{1,4}[A-Z]{0,1}\\b");
		Matcher m = p.matcher(blockNumber);
		return m.matches();
	}
}
