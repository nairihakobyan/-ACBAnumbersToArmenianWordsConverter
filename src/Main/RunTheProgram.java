package Main;
import java.util.Scanner;

import Source.NumbersToArmenianWordsConverter;

public class RunTheProgram{
public static void main(String[] args)   {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number");
		double number = scan.nextDouble();
		
		System.out.print( NumbersToArmenianWordsConverter.convert(number));
		scan.close();
		
		

		
	}
}