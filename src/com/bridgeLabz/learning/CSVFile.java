package com.bridgeLabz.learning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
		List<Details> myList = new ArrayList<>();
		myList.add(
				new Details("Umesh", "deora", "talkiya", "jaitaran", "raj", 1, (long) 1234567890, "umesh@gmail.com"));
		myList.add(new Details("mahesh", "paliwal", "phalodi", "jodhpur", "raj", 1, (long) 1234567890,
				"mahesh@gmail.com"));

		FileWriter fileWriter = new FileWriter(ADDRESS_FILE_PATH);
		fileWriter.append("\n");
		for (Details data : myList) {
			fileWriter.append(String.valueOf(data.getFirstName()));
			fileWriter.append(String.valueOf(","));
			fileWriter.append(String.valueOf(data.getLastName()));
			fileWriter.append(String.valueOf(","));
			fileWriter.append(String.valueOf(data.getAddress()));
			fileWriter.append(String.valueOf(","));
			fileWriter.append(String.valueOf(data.getCity()));
			fileWriter.append(String.valueOf(","));
			fileWriter.append(String.valueOf(data.getState()));
			fileWriter.append(String.valueOf(","));
			fileWriter.append(String.valueOf(data.getZip()));
			fileWriter.append(String.valueOf(","));
			fileWriter.append(String.valueOf(data.getMobNum()));
			fileWriter.append(String.valueOf(","));
			fileWriter.append(String.valueOf(data.getEmail()));
			fileWriter.append("\n");
		}
		fileWriter.flush();
		fileWriter.close();
	}

	public int readFile() throws IOException {
		BufferedReader fileReader = null;
		List<Details> persons = new ArrayList<>();
		String line = "";
		fileReader = new BufferedReader(new FileReader(ADDRESS_FILE_PATH));
		fileReader.readLine();
		while ((line = fileReader.readLine()) != null) {
			String[] data = line.split(",");
			if (data.length > 0) {
				Details student = new Details(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]),
						Long.parseLong(data[6]), data[7]);
				persons.add(student);
			}
		}
		int count = 0;
		for (Details data : persons) {
			System.out.println(data.toString());
			count++;
		}
		return count;
	}
}
