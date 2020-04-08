package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculator {
	
	public double calculate(String path) {
		
		Calculation calculation = new Calculation(0.0);
		Scanner reader = extractFileReader(path);
		
		while(reader.hasNext())
			calculation.processOperation(reader.nextLine());
		
		return calculation.getResult();
	}
	
	private Scanner extractFileReader(String path) {
		
		Scanner reader = null;
		try {
			reader = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File: '" + path + "' not found.");
		}
		
		return reader;
	}
}
