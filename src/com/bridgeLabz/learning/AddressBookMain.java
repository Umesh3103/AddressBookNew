package com.bridgeLabz.learning;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to addressBook problem");
		Persons addressBook = new Persons();
		while(true){
			System.out.println("1. add contacts\n 2.exit");
			System.out.println("Enter your choice");
			int n=sc.nextInt();
			switch(n){
			case 1:
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
				addressBook.addContacts(firstName, lastName, address, city, state, zip, mobNum, email);
				break;
			case 2:
				System.exit(0);
			}
		}
		
		
		
		


	}
}
