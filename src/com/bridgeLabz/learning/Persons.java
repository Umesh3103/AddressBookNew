package com.bridgeLabz.learning;

import java.util.*;

public class Persons {

		ArrayList<Details> contacts;
		Map<String,String> cityMap = new HashMap<>();
		Map<String,String> stateMap = new HashMap<>();
		
		public Persons() {
			contacts =new ArrayList<Details>();
			cityMap = new HashMap<String,String>();
			stateMap = new HashMap<String,String>();
			// TODO Auto-generated constructor stub
		}
		
		public void addContacts(String firstName, String lastName, String address, String city, String state, int zip, Long mobNum,
				String email){
			Details c = new Details(firstName,lastName, address, city, state, zip,mobNum,email);
			contacts.add(c);
			cityMap.put(firstName, city);
			stateMap.put(firstName, state);
		}
		
		public void editContacts(String name){
			Scanner sc = new Scanner(System.in);
			for(int i=0; i<contacts.size();i++){
				Details p = (Details) contacts.get(i);
				if(name.equals(p.getFirstName())){
					String firstName=sc.nextLine();
					String lastName=sc.nextLine();
					String address=sc.nextLine();
					String city=sc.nextLine();
					String state=sc.nextLine();
					int zip=sc.nextInt();
					Long mob = sc.nextLong();
					String email=sc.next();
					p.setFirstName(firstName);
					p.setLastName(lastName);
					p.setAddress(address);
					p.setCity(city);
					p.setState(state);
					p.setZip(zip);
					p.setMobNum(mob);
				}
			}
		}	
		public void viewContacts(){
			for(int i=0;i<contacts.size();i++){
				System.out.print(contacts.get(i).getFirstName()+" ");
				System.out.print(contacts.get(i).getLastName()+" ");
				System.out.print(contacts.get(i).getAddress()+" ");
				System.out.print(contacts.get(i).getCity()+" ");
				System.out.print(contacts.get(i).getState()+" ");
				System.out.print(contacts.get(i).getZip()+" ");
				System.out.print(contacts.get(i).getMobNum()+" ");
				System.out.println(contacts.get(i).getEmail());
				}
			}
	
		public int deleteContacts(String name){
			for(int i=0; i<contacts.size();i++){
				Details p = (Details) contacts.get(i);
				if(name.equals(p.getFirstName())){
					contacts.remove(i);
					return 1;
				}
			}
			return 0;
		}

		public boolean checkDuplicate(String name){
			for(int i=0; i<contacts.size();i++){
				Details p = (Details) contacts.get(i);
				if(name.equals(p.getFirstName())){
					return true;
				}
			}
			return false;
		}
		
		public void searchPersonByCity(String city){
			for(Map.Entry<String,String> entry: cityMap.entrySet()){
				if(entry.getValue().equals(city)){
					System.out.println("Person living in city "+city+" is "+entry.getKey());
				}
			}
			
		}
		
		public void searchPersonByState(String state){
			for(Map.Entry<String,String> entry: stateMap.entrySet()){
				if(entry.getValue().equals(state)){
					System.out.println("Person living in city "+state+" is "+entry.getKey());
				}
			}
			
		}
}
