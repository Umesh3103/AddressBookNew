package com.bridgeLabz.learning;

import java.util.Scanner;


import java.util.*;

public class AddressBookMain {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Persons addressBook = new Persons();
		Persons addressBook2 = new Persons();
		int flag;
		
		while(true){
			System.out.println("In which addressBook you wants to add details. Press 0 for addressBook1 and 1 for addressBook2");
			flag= sc.nextInt();
			System.out.println("1. add contacts\n 2. edit contacts\n 3. delete contacts\n 4. viewContacts\n 5. exit.");
			int n;
			System.out.println("Enter your choice");
			n=sc.nextInt();
			System.out.println("");
		switch(n){
		case 1:
			System.out.println("Create new contacts");
			System.out.println("enter first name");
			String firstName =sc.next();
			System.out.println("enter last name");
			String lastName =sc.next();
			System.out.println("enter address");
			String address =sc.next();
			System.out.println("enter city");
			String city =sc.next();
			System.out.println("enter state");
			String state =sc.next();
			System.out.println("enter zip");
			int zip =sc.nextInt();
			System.out.println("enter mobile number");
			Long mobNum =sc.nextLong();
			System.out.println("enter email");
			String email =sc.next();
			if(flag==0){
			addressBook.addContacts(firstName, lastName, address, city, state, zip, mobNum, email);
			}
			else{
				addressBook2.addContacts(firstName, lastName, address, city, state, zip, mobNum, email);
			}
			break;
		
		case 2:
			System.out.println("Enter the name for which you wants to edit contacts");
			String name = sc.next();
				if(flag==0){
				addressBook.editContacts(name);
				}
				else{
					addressBook2.editContacts(name);
				}
				System.out.println("Edited contacts");
				addressBook.viewContacts();
			
			break;
			
		case 3:
			String s = sc.next();
			int i;
			if(flag==0){
			i = addressBook.deleteContacts(s);
			}
			else{
				i=addressBook2.deleteContacts(s);
			}
			if(i==0){
				System.out.println("Given contact does not exist");
			}
			break;
		case 4:
			if(flag==0){
				addressBook.viewContacts();
			}
			else{
				addressBook2.viewContacts();
			}
			break;
			
		case 5:
			System.exit(0);
			break;
		}
		
		}	
	}

}

