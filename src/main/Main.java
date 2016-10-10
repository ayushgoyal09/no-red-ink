package main;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Main {

	public static void main(String ar[]) {
		List<Questions> questionsList = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of questions");
		
		int questions = sc.nextInt();

		// check if questions is greater that 0;
		if (questions == 0)
			System.out.println("Questions cannot be zero\n");
		else if (questions < 0)
			System.out.println("Questions cannot be negative\n");
		
		
		try{
			Reader in = new FileReader("path/to/file.csv");
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			for (CSVRecord record : records) {
				Questions question = new Questions();
				question.setStrandId(record.get(0));
				question.setStrandName(record.get(1));
				question.setStandardId(record.get(2));
				question.setStandardName(record.get(3));
				question.setQuestionId(record.get(4));
				question.setDifficulty(record.get(5));
				questionsList.add(question);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

	}

}
