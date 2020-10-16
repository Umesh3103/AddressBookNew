package com.bridgeLabz.learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddressBookFileIOService {

	public static String ADDRESS_FILE_NAME = "address-file.txt";

	public void writeData(Map<List<Details>, Integer> contactMap) {
		StringBuffer contactBuffer = new StringBuffer();
		for (Map.Entry<List<Details>, Integer> entry : contactMap.entrySet()) {
			entry.getKey().forEach(contact -> {
				String contactDataString = contact.toString().concat("\n");
				contactBuffer.append(contactDataString);
			});
		}
		try {
			Files.write(Paths.get(ADDRESS_FILE_NAME), contactBuffer.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printData() {
		try {
			Files.lines(new File(ADDRESS_FILE_NAME).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(ADDRESS_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entries;
	}

	List<Details> contactList = new ArrayList<>();

	public List readFile() {

		try {
			Files.lines(new File(ADDRESS_FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> {
				line = line.replace(",", "");
				line = line.replace("=", " ");
				String[] data = line.split(" ");
				contactList.add(new Details(data[1], data[3], data[5], data[7], data[9], Integer.parseInt(data[11]),
						Long.parseLong(data[13]), data[15]));
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactList;
	}

}
