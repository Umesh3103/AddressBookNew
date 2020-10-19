package com.bridgeLabz.learning;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class JSonFile {

	public void writeToJson() throws IOException{
		List<Details> myList = Arrays.asList(new Details("Umesh", "deora", "talkiya", "jaitaran", "raj", 1, (long) 1234567890, "umesh@gmail.com"),
				new Details("mahesh", "paliwal", "phalodi", "jodhpur", "raj", 1, (long) 1234567890,
						"mahesh@gmail.com"));
		Writer writer = new FileWriter("person.json");
		new Gson().toJson(myList, writer);
	}
	
    
}
