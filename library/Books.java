package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class Books {
	
	static HashMap<String,String> books = new HashMap<>();
	static Scanner scan  = new Scanner(System.in);
	static HashMap<String,String> users = new HashMap<>();
	static HashMap<String,String> librarian = new HashMap<>();
	static HashMap<String,String> borrowed = new HashMap<>();
	static int input;
	static String iter;
	
	
	
	//create new user
	public static void user()
	{
	
		 System.out.println("Register your username");
		 String temp = scan.next();
		 users.put(temp, null);
		 System.out.println("enter your password");
		 users.put(temp,scan.next());
		 System.out.println("account created successfully & enter your username and pasword details to continue");
	}
	
	//performing to display list of books
	public static void listBooks()
	{
	
		System.out.printf("%-20s%10s","AuthorName","BookName"+"\n");
		for(Map.Entry<String, String>get : books.entrySet())
		{
			
			System.out.printf("%-20s%10s",get.getKey(),get.getValue()+"\n");
			
		}
		System.out.println();
	}
		 
	
	
	// performing get book by reader
	public static void getBook(String name,String userr)
	{
		int count = 0;
		for(Map.Entry<String, String>loop :books.entrySet())
		{
			if(name.equalsIgnoreCase(loop.getValue()))
			{
				System.out.println("book borrowed successfully");
				borrowed.put(userr, name);
				books.put(loop.getKey(), "empty");
				iter=loop.getKey();
				break;
			}
			else 
			{
				count +=1;
				
			
			}
		}
		if(count>=1){System.out.println("book not available :( ");}
		System.out.println();
		
	}
	
	// returning function to return book by reader
	public static void returnBook(String name,String userr)
	{
		for(Map.Entry<String, String>loop :books.entrySet())
		{
			if(loop.getKey().equals(iter))
			{
				System.out.println("book returned successfully");
				books.put(loop.getKey(), name);
				iter="";
				break;
			}
		}
		borrowed.remove(userr, name);
		System.out.println();
	}
	
	
	
	
	
	// check userName & Password to verify 
	public static boolean checKuser(String uName,String password)
	{
		int count = 0;
		
		if(input==1){
		for(Map.Entry<String, String>loop :users.entrySet())//verify for user
		{
			
			if(uName.equalsIgnoreCase(loop.getKey())&&password.equalsIgnoreCase(loop.getValue()))
			{
				System.out.println("welcome back Reader");
				count = 0;
				break;
				
			}
			else
			{
				count = 1;
			}
		}
		System.out.println();
		}
		else
		{
			for(Map.Entry<String, String>loop :librarian.entrySet())//verify for librarian
			{
				
				if(uName.equalsIgnoreCase(loop.getKey())&&password.equalsIgnoreCase(loop.getValue()))
				{
					System.out.println("welcome back Librarian");
					count = 0;
					break;
					
				}
				else
				{
					count = 1;
				}
			}
			System.out.println();
			
			
		}
		
	
		if(count==1)
		{
			System.out.println("Mismatch : username or password");
			return false;
		}
		else{
			return true;
		}
		
		
		
	}	
	
	
	
	
// access only by librarian to add book to library 
	public static void addBooks()
	{
		System.out.println("Enter how many books want to enter");
		int count  = scan.nextInt();
		
		for(int loop = 0;loop<count;loop++)
		{
			System.out.println("enter book author name & book name");
			books.put(scan.next(), scan.next());
			
			
		}
		
	}
	
	
// performing book search to check available or not
	public static void searchBook(String name) 
	{
		int check = 0;
		
		
			for(Map.Entry<String, String>loop :books.entrySet()){
			
					 if(loop.getValue().equalsIgnoreCase(name))
						{
						System.out.println(loop.getValue()+" is available in the library");
						break;
						}
					else if(loop.getKey().equalsIgnoreCase(name))
					{
						System.out.println("your requested authors books available in library");
						System.out.println(loop.getValue());
						check = 0;
					}
					
					else
					 {
						 check = 1;
					 }
			}
		
	
	if(check==1){System.out.println(name+" type of book is not available in the library");}
	System.out.println();
	}
	
			

	
//Main class	

	public static void main(String[] args) 
	{
		
			System.out.printf("%60s","WELCOME TO LIBRARY");
			System.out.println();
		
			books.put("J.k Rowling", "HarryPotter");
			books.put("stannlee", "Marvel comics");
			books.put("Major", "DC comics");
			
			users.put("mugesh", "12345");
			users.put("subu", "12456");
			
		
		
		String username = "";
		
		
		for(int i = 0;i<100;i++){
			
			
			 System.out.println("If your'e Reader Enter 1"+"\nIf your'e Librarian Enter 2");
			 try{
			 input = scan.nextInt();
	
		 
		switch(input){						
		
		case(1):
			for(int j = 0;j<20;j++){
			System.out.println("For New user Enter 1"+"\nAlready an user Enter 2");	
			try{
			int option = scan.nextInt();
			
							
		
			if(option==1)
			{							
				user();
			}
				
		
			else if(option==2)
			{
				
				System.out.print("Enter your Username : ");
				String name = scan.next();
				System.out.print("Enter your Password : ");		
				String pass = scan.next();
				System.out.println();
				
				
				if(checKuser(name, pass)==true)
				{
				username = name;
				
				for(int it = 0 ;it<100;it++ )
				{
				System.out.println("To see books list enter 1");
				System.out.println("To get book enter 2");
				System.out.println("To search book enter 3");
				System.out.println("To return book  enter 4");
				System.out.println("To end process enter 5");
				try{
				int optio = scan.nextInt();						
		
							if(optio==1)
							{
							
								listBooks();
								continue;									
							}
							
							else if(optio==2)
							{
								System.out.print("Enter Book Name:");
								String names = scan.next();					
								getBook(names, username);
								continue;
							}
								
								
							else if(optio==3)
							{
								System.out.print("Enter Book Name or Author Name : ");
								String bookName = scan.next();				
								searchBook(bookName);
								continue;
							}
								
							else if(optio==4)
							{
								System.out.print("Enter Book Name : ");
								String nam = scan.next();					
								returnBook(nam, username);
								continue;
							}
								
							else if(optio==5)
							{										
								break;	
							}
						}
						catch(Exception e)
						{
							System.out.println("Enter valid Input");
							scan.nextLine();
							System.out.println();
							continue;
						}
							
							break;
						}
							
					}
						else
						{
							System.out.println("retry");
							continue;
						}
					
					}
			}
			catch(Exception e)
			{
				System.out.println("Enter valid Input");
				scan.nextLine();
				System.out.println();
				continue;
			}
			 
			break;
			}
		break;
		
		case(2):
			
			librarian.put("librarian1", "welcome22");
			System.out.print("Enter Your Username  : ");
			String name = scan.next();								
			System.out.print("Enter Your Password : ");
			String pass = scan.next();
			
			if(checKuser(name,pass)==true)
			{
			
			System.out.println("Enter 1 to add books");
			System.out.println("Enter 2 to get borrowed list ");
			System.out.println("Enter 3 to see books list ");
			System.out.println("Enter 4 to end process\n");
			
			int books = scan.nextInt();
			
					if(books==1)
					{
						addBooks();								
						continue;
					}
					
					else if(books==2)
					{
						System.out.print("Borrower list : ");
						for(Map.Entry<String, String>details:borrowed.entrySet())				
						{
						System.out.println(details.getKey()+" : "+details.getValue());
						}
						continue;
					}
					
						
					else if(books==3)
					{
						continue;
					}
					
					else if(books==4)
					{										
						break;	
					}
			
			}
			
			else{
				System.out.println("retry");
				continue;
			}
			
			default:
			System.out.println("Enter valid input");
			continue;
			
			
		}//switch 1
		
			 }
				catch(Exception e)
				{
					System.out.println("Enter valid Input");
					scan.nextLine();
					System.out.println();
					continue;
				}
		
		
		break;
		
	}//for 
		
		
		
  }//main
}//class


	

		
	
	

