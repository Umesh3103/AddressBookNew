package com.bridgeLabz.learning;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("Welcome to addressBook problem");
		Scanner sc= new Scanner(System.in);
		Persons addressBook = new Persons();
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
		Details p = new Details(firstName, lastName, address, city, state, zip, mobNum, email);

	}
}
