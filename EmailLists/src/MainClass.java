import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

public class MainClass {
	
	public static void main(String[] args)throws IOException {
		System.out.println("Welcome to Email Lists");
		System.out.println("-------By Mayank Khera");
		Directory dir = new Directory();
		boolean quit = false;
		do {
			System.out.println("Enter c to create a new list");
			System.out.println("      p to display all list");
			System.out.println("      a to add an entry to the list");
			System.out.println("      d to delete from a list");
			System.out.println("      l to display a list");
			System.out.println("      f to load a list from file");
			System.out.println("      q to quit :p");
			Scanner input = new Scanner(System.in);
			char option = input.next().charAt(0);
			switch(option) {
			case 'c':
				System.out.print("Enter the name of the list: ");
				String name = input.next();
				dir.addList(name);
				while(true) {
					dir.findList(name).add(input, "yes");
					System.out.print("Another? y/n: ");
					char op = input.next().toLowerCase().charAt(0);
					if(op=='n')
						break;
				}
				break;
				
			case'p':
				System.out.println(dir);
				break;
				
			case 'a':
				System.out.print("Enter name of list to add to: ");
				String add = input.next();
				do{
					if(dir.findList(add)!=null) {
						boolean another = true;
						while(another) {
							dir.findList(add).add(input, "yes");
							System.out.print("Another? y/n: ");
							char prompt = input.next().toLowerCase().charAt(0);
							if(prompt=='n')
								another = false;
						}
					}else {
						System.out.println("List not found!!");
						System.out.print("Enter name of list to add to: ");
						add = input.next();
					}
				}while(dir.findList(add)==null);
				break;
				
			case 'd':
				/*System.out.print("Enter name of list to delete from: ");
				String lame = input.next();
				do {
					if(dir.findList(lame)!=null) {
						System.out.print("Enter the email you want to delete: ");
						String del = input.next();
						if(dir.findList(lame).remove(del))
							System.out.println("Succesfully deleted");
						else
							System.out.println("Email not found in the list");
					}else {
						System.out.println("List not found");
						System.out.print("Enter name of list to delete from: ");
						lame = input.next();
					}
						
				}while(dir.findList(lame)==null);*/
				String lame;
				do{
					System.out.print("Enter name of list to delete from: ");
					lame = input.next();
					if(dir.findList(lame)==null)
						System.out.println("List not found!");
				}while(dir.findList(lame)==null);
				boolean isValid = false;
				int index = -1;
				do {
					System.out.print("Enter index to delete: ");
					
					if(input.hasNextInt()) {
						index = input.nextInt();
						isValid = true;
						if(index<0) {
							System.out.println("Please enter a positive number!!");
							isValid = false;
						}
					}else {
						System.out.println("Please enter a valid integer!!");
					}
				}while(!isValid);
				try {
					System.out.println(dir.findList(lame).remove(index));
				}catch(IndexOutOfBoundsException e) {
					System.out.println("Index out of bounds!! Could not delete");
				}
				break;
				
			case 'l':
				System.out.print("Enter name of list to display: ");
				String displayList = input.next();
				System.out.println(dir.findList(displayList));
				break;
				
			case 'f':
				System.out.print("Enter file name: ");
				String fname = input.next();
				String error = "Bad file...Terminating program";
				try {
					input = new Scanner(Paths.get(fname));
				}catch(IOException e) {
					System.err.println(error);
					return;
				}
				if(!input.equals(null)) {
					
					if(input.hasNextInt()) {
						
						int numlist = input.nextInt();
						for(int i=0; i<numlist; i++) {
							
							if(!input.nextLine().equals(null)) {
								
								String lname = input.next();
								dir.addList(lname);
								if(input.hasNextInt()) {
									
									int numEmail = input.nextInt();
									for(int j=0; j<numEmail; j++) {
										dir.findList(lname).add(input, "no");
									}
								}else {
									System.err.println(error);
									return;
								}
							}else {
								System.err.println(error);
								return;
							}
						}
					}else {
						System.err.println(error);
						return;
					}
				}else {
					System.err.println(error);
					return;
				}
				input = new Scanner(System.in);
				break;
				
			case 'q':
				System.out.println("Have a good day!!");
				quit = true;
				break;
				
			default:
				System.out.println("Please enter a valid choice!!");
			}
		}while(!quit);
	}
}
