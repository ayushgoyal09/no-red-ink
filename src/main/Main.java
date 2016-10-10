package main;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Main {

	public static void main(String ar[]) {
		List<Questions> questionsList = new ArrayList<>();
		Map<String,String> question_strand_map = new HashMap<>();
		
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
		
		for (Questions q : questionsList){
			question_strand_map.put("question "+q.getQuestionId(), q.getStrandId());
		}
		
		System.out.println(question_strand_map);
		
		//Randomly select 1 or 2.
		Random random = new Random();
		int pick = random.nextInt()%2==0?1:2;
		
		for(int i=1;i<=questions;i++){
			List<String> keys = new ArrayList<>(question_strand_map.keySet());
			String randomKey = keys.get(random.nextInt(keys.size()));
			String val = question_strand_map.get(randomKey);
			
		}
		
		

	}

}
