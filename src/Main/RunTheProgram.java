package Main;
import java.util.Scanner;
import java.util.InputMismatchException;
import Source.NumbersToArmenianWordsConverter;

public class RunTheProgram{
public static void main(String[] args)   {
		
	
		Scanner scan = new Scanner(System.in);	
		//because of the loop it accepts two enters
		for(int i = 0;i < 100;i++) {
			System.out.println("Please input numbers between 0 and 1 quadrillion(not including)"+"\n"
					+ "hit Enter twice" );
			double number = scan.nextDouble();
			
			if(number < 1000000000000000l && number > 0)  {
				System.out.println( NumbersToArmenianWordsConverter.convert(number));
			}
		
			else {
				throw new InputMismatchException();
			}
		}
		
	}
}
