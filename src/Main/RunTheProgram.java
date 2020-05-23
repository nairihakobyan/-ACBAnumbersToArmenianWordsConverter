package Main;
import java.util.Scanner;

import Source.NumbersToArmenianWordsConverter;

public class RunTheProgram{
public static void main(String[] args)   {
		Scanner scan = new Scanner(System.in);
		for(int i = 0;i<100;i++) {
		
		System.out.println("Please enter a number");
		double number = scan.nextDouble();
		
		System.out.println( NumbersToArmenianWordsConverter.convert(number));
		
		}
		scan.close();
		

		
	}
}