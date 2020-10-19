package com.bridgeLabz.learning;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class JsonFileTest {

	CSVFile person = new CSVFile();

	@Test
	public void GivenJsonFile_WhenReading_ShouldSize()
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		person.writeToFile();
		int result = person.readFile();
		Assert.assertEquals(2, result);
	}
}
