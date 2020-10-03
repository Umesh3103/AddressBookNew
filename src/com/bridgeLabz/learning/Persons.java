package com.bridgeLabz.learning;

import java.util.*;

public class Persons {

		ArrayList<Details> contacts;

		public Persons() {
			contacts =new ArrayList<Details>();
			// TODO Auto-generated constructor stub
		}
		
		public void addContacts(String firstName, String lastName, String address, String city, String state, int zip, Long mobNum,
				String email){
			Details c = new Details(firstName,lastName, address, city, state, zip,mobNum,email);
			contacts.add(c);
		}

}
