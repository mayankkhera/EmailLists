import java.util.ArrayList;

public class Directory {
	private ArrayList<EmailList> lists;
	
	public Directory() {
		lists = new ArrayList<EmailList>();
	}
	
	public Directory(int numLists) {
		lists = new ArrayList<EmailList>(numLists);
	}
	
	public void addList(String add) {
		EmailList temp = new EmailList(add);
		lists.add(findIndex(add), temp);
	}
	
	/*
	 * Binary search method taken from assignment 2 solution
	 * Author: Linda Crane
	 */
	public EmailList findList(String toFind) {
		int high = lists.size()-1;
		int low = 0;
		
		while(low <= high) {
			int middle = (high + low)/2;
			if(lists.get(middle).isEqual(toFind))
				return lists.get(middle);
			if(lists.get(middle).isGreaterThan(toFind))
				high = middle -1;
			else low = middle + 1;
		}
		return null;
	}
	
	/*
	 * Binary search method for index taken from assignment 2 solution
	 * Author: Linda Crane
	 */
	private int findIndex(String toFind) {
		int high = lists.size()-1;
		int low = 0;
		
		while (low <= high) {
			int middle = (high+low)/2;
			if (lists.get(middle).isEqual(toFind))
				return middle;
			if (lists.get(middle).isGreaterThan(toFind)) 
				high = middle-1;
			else low = middle+1;
		}
		return low;
	}
	
	public String toString() {
		String retVal = "The email lists are: \n\n";
		for(int i=0; i<lists.size(); i++) {
			retVal += lists.get(i).toString();
		}
		return retVal;
	}
}
