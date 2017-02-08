package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;
import java.util.ArrayList;
/**
 * Tagging Association class for associating Person and Tag.
 * @author CHUAN
 *
 */
public class Tagging {
	private Person person;
	private Tag tag;
	private String tagOperation;
	public static ArrayList<Tagging> TaggingList;//class-level ArrayList that contains all the tags
	/**
	 * after instantiating a Tagging object, adds the object to the class-level ArrayList
	 * @param person Person to be associated
	 * @param tag Tag to be associated
	 * @param tagOperation Add or Delete operation
	 */
	public Tagging(Person person, Tag tag, String tagOperation){
		this.person = person;
		this.tag = tag;
		this.tagOperation = tagOperation;
		TaggingList.add(this);
		
	}
	
	public Person getPerson(){
		return person;
	}
	
	public Tag getTag(){
		return tag;
	}
	
	public String getTagOperation(){
		return tagOperation;
	}
	
}
