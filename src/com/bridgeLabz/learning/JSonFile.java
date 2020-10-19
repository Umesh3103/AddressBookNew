package com.bridgeLabz.learning;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class JSonFile {

	public void writeToJson() throws IOException {
		List<Details> myList = Arrays.asList(
				new Details("Umesh", "deora", "talkiya", "jaitaran", "raj", 1, (long) 1234567890, "umesh@gmail.com"),
				new Details("mahesh", "paliwal", "phalodi", "jodhpur", "raj", 1, (long) 1234567890,
						"mahesh@gmail.com"));
		Gson gson = new Gson();
		Writer writer = Files.newBufferedWriter(Paths.get("contacts.json"));
		gson.toJson(myList, writer);
		writer.close();
	}

	public int readJson() throws IOException {
		Gson gson = new Gson();
		Reader reader = Files.newBufferedReader(Paths.get("books.json"));
		List<Details> contacts = Arrays.asList(gson.fromJson(reader, Details[].class));
		contacts.forEach(System.out::println);
		reader.close();
		return contacts.size();
	}

}
