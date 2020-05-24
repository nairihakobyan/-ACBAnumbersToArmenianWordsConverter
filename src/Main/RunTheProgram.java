package Main;
import java.util.Scanner;
import java.util.InputMismatchException;
import Source.NumbersToArmenianWordsConverter;

public class RunTheProgram{
public static void main(String[] args)   {
		
	
		Scanner scan = new Scanner(System.in);
		for(int i = 0;i < 100;i++) {
			
		System.out.println("Please input numbers from 0 to 1 quadrillion(not including)"+"\n" );
		
		double number = scan.nextDouble();
		if(number < 1000000000000000l && number > 0)  {
			System.out.println( NumbersToArmenianWordsConverter.convert(number));
		}
		
		else {
			throw new InputMismatchException();
			}
		}
		scan.close();
	}
}
