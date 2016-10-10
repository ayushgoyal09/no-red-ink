package main;

import java.util.Scanner;

public class Main {

	public static void main(String ar[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of questions");
		
		int questions = sc.nextInt();

		// check if questions is greater that 0;
		if (questions == 0)
			System.out.println("Questions cannot be zero\n");
		else if (questions < 0)
			System.out.println("Questions cannot be negative\n");
		
		
		
		

	}

}
