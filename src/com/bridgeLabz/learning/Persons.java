package com.bridgeLabz.learning;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Persons {

		List<Details> contacts;
		Map<List<Details>, Integer> contactMap=new HashMap<>();
		Map<String,String> cityMap = new HashMap<>();
		Map<String,String> stateMap = new HashMap<>();
		public Persons() {
			contacts =new ArrayList<Details>();
			cityMap = new HashMap<String,String>();
			stateMap = new HashMap<String,String>();
			// TODO Auto-generated constructor stub
		}
		
		public void addContacts(int addressBook, String firstName, String lastName, String address, String city, String state, int zip, Long mobNum,
				String email){
			contacts =new ArrayList<Details>();			
			boolean result = contactMap.entrySet().stream().filter(p-> p.getValue().equals(firstName)).findAny().orElse(null) != null;
			if(result){
				System.out.println("name already exist in the addressBook");
			}
			else{
			Details c = new Details(firstName,lastName, address, city, state, zip,mobNum,email);
			contacts.add(c);
			contactMap.put(contacts,addressBook);
			cityMap.put(firstName, city);
			stateMap.put(firstName, state);
			}
		}
		
		public void editContacts(int addressBook,String name){
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
					contactMap.replace(contacts,addressBook);
				}
				
			}
		}	
		public void viewContacts(){
			for(Map.Entry<List<Details>,Integer> listEntry: contactMap.entrySet()){
				for(Details view : listEntry.getKey()){
					System.out.print(view.getFirstName()+" ");
					System.out.print(view.getLastName()+" ");
					System.out.print(view.getAddress()+" ");
					System.out.print(view.getCity()+" ");
					System.out.print(view.getState()+" ");
					System.out.print(view.getZip()+" ");
					System.out.print(view.getMobNum()+" ");
					System.out.println(view.getEmail());
					
				}
			}
		}	
	
		public int deleteContacts(String name){
			for(Map.Entry<List<Details>, Integer> entry: contactMap.entrySet()){
				List<Details> p = entry.getKey();
				for(int i=0;i<p.size();i++){
				if(name.equals(p.get(i))){
					contactMap.remove(name);
					return 1;
				}
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
		public void viewPersonByCity(String city){
			cityMap.entrySet().stream()
					.filter(x-> city.equals(x.getValue()))
					.forEach(x->{
						System.out.println("person living in city "+city+" are "+x.getKey());
					});
					
			
		}
		
		public void viewPersonByState(String state){
			stateMap.entrySet().stream()
			.filter(x-> state.equals(x.getValue()))
			.forEach(x->{
				System.out.println("person living in state "+state+" are "+x.getKey());
			});
			
		}
		
		public void searchPersonByNameForCity(String name){
			int flag=0;
			for(Map.Entry<String,String> entry: cityMap.entrySet()){
				if(entry.getKey().equals(name)){
					System.out.println("Person "+name+" lives in "+entry.getValue());
					flag=1;
				}
			}
			if(flag==0){
				System.out.println("Name does not exist");
			}
		}
		
		public void searchPersonByNameForState(String name){
			int flag=0;
			for(Map.Entry<String,String> entry: stateMap.entrySet()){
				if(entry.getKey().equals(name)){
					System.out.println("Person "+name+" lives in "+entry.getValue());
					flag=1;
				}
				
			}
			if(flag==0){
				System.out.println("Name does not exist");
			}
		}
		public int countPersonsByCity(String city){
			return (int) cityMap.entrySet().stream()
			.filter(x-> city.equals(x.getValue()))
			.count();
		}
		public int countPersonsByState(String state){
			return (int) stateMap.entrySet().stream()
					.filter(x-> state.equals(x.getValue()))
					.count();
		}
		
		public void sortByName(){
			for(Map.Entry<List<Details>, Integer> entry : contactMap.entrySet()){
			List<Details> listSortedByFirstName=entry.getKey().stream().sorted(Comparator.comparing(Details::getFirstName)).collect(Collectors.toList());
			 for(Details person: listSortedByFirstName) {
		            System.out.println("Sorted by name: "+person.getFirstName()+" "+person.getLastName()+" "+person.getAddress()+" "+person.getCity()+" "+person.getState()+" "+person.getZip()+" "+person.getMobNum()+" "+person.getEmail());
		        }
			}
		}
		
}
