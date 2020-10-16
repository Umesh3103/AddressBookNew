package com.bridgeLabz.learning;

import java.util.Scanner;

import java.util.*;

public class AddressBookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Persons addressBook = new Persons();
		Persons addressBook2 = new Persons();
		int flag;

		while (true) {
			System.out.println(
					"In which addressBook you wants to add details. Press 0 for addressBook1 and 1 for addressBook2");
			flag = sc.nextInt();
			System.out.println(
					"1. add contacts\n 2. edit contacts\n 3. delete contacts\n 4. viewContacts\n 5. search by city\n 6. search person by state\n 7. view person by city\n 8. view person by state\n 9. count person by city\n 10. count person by state\n 11.sort\n 12. write file\n 13. read file\n 14. exit.");
			int n;
			System.out.println("Enter your choice");
			n = sc.nextInt();
			System.out.println("");
			switch (n) {
			case 1:
				System.out.println("Create new contacts");
				System.out.println("enter first name");
				String firstName = sc.next();
				System.out.println("enter last name");
				String lastName = sc.next();
				System.out.println("enter address");
				String address = sc.next();
				System.out.println("enter city");
				String city = sc.next();
				System.out.println("enter state");
				String state = sc.next();
				System.out.println("enter zip");
				int zip = sc.nextInt();
				System.out.println("enter mobile number");
				Long mobNum = sc.nextLong();
				System.out.println("enter email");
				String email = sc.next();
				if (flag == 0) {
					addressBook.addContacts(flag, firstName, lastName, address, city, state, zip, mobNum, email);
				} else {
					addressBook2.addContacts(flag, firstName, lastName, address, city, state, zip, mobNum, email);
				}
				break;

			case 2:
				System.out.println("Enter the name for which you wants to edit contacts");
				String name = sc.next();
				if (flag == 0) {
					addressBook.editContacts(flag, name);
				} else {
					addressBook2.editContacts(flag, name);
				}
				System.out.println("Edited contacts");
				addressBook.viewContacts();

				break;

			case 3:
				String s = sc.next();
				int i;
				if (flag == 0) {
					i = addressBook.deleteContacts(s);
				} else {
					i = addressBook2.deleteContacts(s);
				}
				if (i == 0) {
					System.out.println("Given contact does not exist");
				}
				break;
			case 4:
				if (flag == 0) {
					addressBook.viewContacts();
				} else {
					addressBook2.viewContacts();
				}
				break;

			case 5:
				System.out.println("Enter name:");
				String Name = sc.next();
				addressBook.searchPersonByNameForCity(Name);
				addressBook2.searchPersonByNameForCity(Name);
				break;
			case 6:
				System.out.println("Enter state:");
				String name1 = sc.next();
				addressBook.searchPersonByNameForState(name1);
				addressBook2.searchPersonByNameForState(name1);
				break;
			case 7:
				System.out.println("Enter city:");
				String c = sc.next();
				addressBook.viewPersonByCity(c);
				addressBook2.viewPersonByCity(c);
				break;
			case 8:
				System.out.println("Enter state:");
				String st = sc.next();
				addressBook.viewPersonByState(st);
				addressBook2.viewPersonByState(st);
				break;
			case 9:
				System.out.println("Enter city:");
				String ct = sc.next();
				int count = addressBook.countPersonsByCity(ct) + addressBook2.countPersonsByCity(ct);
				System.out.println("count of persons living in city " + ct + " is " + count);
				break;
			case 10:
				System.out.println("Enter State:");
				String st1 = sc.next();
				int countState = addressBook.countPersonsByState(st1) + addressBook2.countPersonsByState(st1);
				System.out.println("count of persons living in state " + st1 + " is " + countState);
				break;
			case 11:
				System.out.println("Sort by: 1. name ");
				int x = sc.nextInt();
				if (x == 1) {
					addressBook.sortByName();
					addressBook2.sortByName();
				}
				if (x == 2) {
					addressBook.sortByCity();
					addressBook2.sortByCity();
				}
				if (x == 3) {
					addressBook.sortByState();
					addressBook2.sortByState();
				}
				if (x == 4) {
					addressBook.sortByZip();
					addressBook2.sortByZip();
				}
				break;
			case 12:
				addressBook.writeToFile();
				addressBook.printData();
				addressBook.countEntries();
				break;
			case 13:
				addressBook.readFile();
				break;
			case 14:
				System.exit(0);
				break;
			}

		}
	}

}
