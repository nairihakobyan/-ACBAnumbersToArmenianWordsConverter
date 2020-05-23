package Main;
import java.util.Scanner;

import Source.NumbersToArmenianWordsConverter;

public class RunTheProgram{
public static void main(String[] args)   {
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0;i < 100;i++) {
			
		System.out.println("Please input numbers from 0 to 1 quadrillion(not including)"+"\n" );
		
		double number = scan.nextDouble();
		
		System.out.println( NumbersToArmenianWordsConverter.convert(number));
		
		}
		scan.close();
	}
}
