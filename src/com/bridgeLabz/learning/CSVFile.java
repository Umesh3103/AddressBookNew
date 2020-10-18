package com.bridgeLabz.learning;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CSVFile {

	private static final String ADDRESS_FILE_PATH = "./users.csv";

	public static void writeToFile() throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		Writer writer = null;
		try {
			writer = Files.newBufferedWriter(Paths.get(ADDRESS_FILE_PATH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StatefulBeanToCsv<Details> myCsv = new StatefulBeanToCsvBuilder(writer)
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
		List<Details> myList = new ArrayList<>();
		myList.add(
				new Details("Umesh", "deora", "talkiya", "jaitaran", "raj", 1, (long) 1234567890, "umesh@gmail.com"));
		myList.add(new Details("mahesh", "paliwal", "phalodi", "jodhpur", "raj", 1, (long) 1234567890,
				"mahesh@gmail.com"));
		myCsv.write(myList);
	}

	public int readFile() throws IOException {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(ADDRESS_FILE_PATH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CSVReader csvReader = new CSVReader(reader);
		List<String[]> records = csvReader.readAll();
		int count = 0;
		for (String[] record : records) {
			System.out.println("First Name : " + record[0]);
			System.out.println("Last Name : " + record[1]);
			System.out.println("Address : " + record[2]);
			System.out.println("City : " + record[3]);
			System.out.println("State : " + record[4]);
			System.out.println("Zip : " + record[5]);
			System.out.println("Mobile no. : " + record[6]);
			System.out.println("Email : " + record[7]);
			System.out.println("---------------------------");
			count++;

		}
		return count;
	}
}
