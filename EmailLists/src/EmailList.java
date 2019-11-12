import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class EmailList {
	private String name;
	private LinkedList<EmailAddress> list;
	
	public EmailList(String name) {
		this.name = name;
		list = new LinkedList<EmailAddress>();
	}
	
	public void add(Scanner in, String prompt) {
		EmailAddress temp = new EmailAddress();
		temp.addAddress(in, prompt);
		list.add(temp);
	}
	
	public EmailAddress remove(int index) {
		/*EmailAddress temp = new EmailAddress(email);
		return list.remove(temp);*/
		return list.remove(index);
	}
	
	public boolean isEqual(String name) {
		if(this.name.equals(name))
			return true;
		return false;
			
	}
	
	public boolean isGreaterThan(String name) {
		if(this.name.compareToIgnoreCase(name)>0)
			return true;
		return false;
	}
	
	public String toString() {
		//Iterator<EmailAddress> i = list.iterator();
		String retVal = name + ": ";
		/*while(i.hasNext()) {
			retVal = retVal + i.next() + ",\n";
		}*/
		retVal = retVal + list.toString();
		retVal = retVal + "\n";
		return retVal;
	}
}
