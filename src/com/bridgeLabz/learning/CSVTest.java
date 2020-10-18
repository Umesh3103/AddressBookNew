package com.bridgeLabz.learning;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CSVTest {

	CSVFile person = new CSVFile();

	@Test
	public void d() throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		person.writeToFile();
		int result = person.readFile();
		Assert.assertEquals(2, result);
	}
}
