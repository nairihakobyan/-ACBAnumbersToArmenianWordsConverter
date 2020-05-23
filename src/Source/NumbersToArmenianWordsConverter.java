package Source;
import java.text.DecimalFormat; 

public class NumbersToArmenianWordsConverter{

private static final String[] tensNames = { 
			"", " տաս", " քսան", " երեսուն", " քառասուն"," հիսուն",
			" վաթսուն"," յոթանասուն", " ութսուն", " իննսուն" };

	private static final String[] numNames = { "", " մեկ", " երկու", " երեք", " չորս", " հինգ", " վեց", " յոթ", " ութ",
			" ինը", " տաս", " տասնմեկ", " տասներկու", " տասներեք", " տասնչորս", " տասնհինգ", " տասնվեց", " տասնյոթ",
			" տասնութ", " տասնինը" };
	
	private static String lumaResult;
	
	private NumbersToArmenianWordsConverter() {
	}
	
	
	private static String convertLessThanOneThousand(int number) {
		String words;

		if (number % 100 < 20) {
			words = numNames[number % 100];
			number /= 100;
		} else {
			words = numNames[number % 10];
			number /= 10;

			words = tensNames[number % 10] + words;
			number /= 10;
		}
		if (number == 0)
			return words;
		return numNames[number] + " հարյուր" + words;
	}
	
	private static String lumaValueInWords(Double given) {
 		 String words="";
 		 long value = new Double(given).longValue(); 
 		 //float cast is to not let the number be rounded
 		 int number = (int) ( 
 				 			( 
 						 (float)(given-value)
 				 			)
 				 *100);
 		
 		 if (number == 0){
			return  "զրո";
 		 	}
 		 while (number > 0) {
 			 if (number % 100 < 20) {
 				 words += numNames[number % 100];
 				 number = 0;
 				 }
 			 else {	
 				 words = tensNames[number / 10] + words;
 				 number %= 10;
 			 	 }
 			 }
 		 return numNames[number] +  words ;
	 }

	public static String convert(Double given)  {
		String result;
		long value =  new Double(given).longValue();
		// 0 to 999 999 999 999 999
		if ( value == 0 && given == 0) {
			result = " զրո դրամ" ;
			return result ;
		}
		else if(value == 0 && given > 0) {
			return result = " զրո դրամ " + lumaValueInWords(given)+" լումա"; 
		}

		String snumber = Double.toString(value);

		// pad with "0"
		DecimalFormat df = new DecimalFormat("000000000000000");
		snumber = df.format(value);
		
		

		int trilions = Integer.parseInt(snumber.substring(0, 3));
		// XXX_nnn_nnn_nnn_nnn
		int billions = Integer.parseInt(snumber.substring(3, 6));
		// nnn_XXX_nnn_nnn_nnn
		int millions = Integer.parseInt(snumber.substring(6, 9));
		// nnn_nnn_XXX_nnn_nnn
		int thousands = Integer.parseInt(snumber.substring(9, 12));
		// nnn_nnn_nnn_XXX_nnn
		int hundreds = Integer.parseInt(snumber.substring(12, 15)); 
		// nnn_nnn_nnn_nnn_XXX
		

		String Trilions;
		switch (trilions) {
		case 0:
			Trilions = "";
			break;
		case 1:
			Trilions = convertLessThanOneThousand(trilions) + " տրիլիոն ";
			break;
		default:
			Trilions = convertLessThanOneThousand(trilions) + " տրիլիոն ";
		}
		 result = Trilions;

		String Billions;
		switch (billions) {
		case 0:
			Billions = "";
			break;
		case 1:
			Billions = convertLessThanOneThousand(billions) + " միլիարդ ";
			break;
		default:
			Billions = convertLessThanOneThousand(billions) + " միլիարդ ";
		}
		result = result + Billions;

		String Millions;
		switch (millions) {
		case 0:
			Millions = "";
			break;
		case 1:
			Millions = convertLessThanOneThousand(millions) + " միլիոն ";
			break;
		default:
			Millions = convertLessThanOneThousand(millions) + " միլիոն ";
		}
		result = result + Millions;

		String Thousands;
		switch (thousands) {
		case 0:
			Thousands = "";
			break;
		case 1:
			Thousands = " հազար ";
			break;
		default:
			Thousands = convertLessThanOneThousand(thousands) + " հազար ";
		}
		result = result + Thousands;

		String Hundreds;
		Hundreds = convertLessThanOneThousand(hundreds);
		result = result + Hundreds;
		
		lumaResult = lumaValueInWords(given) ;
	
		return (result +" դրամ "+lumaResult +" լումա").replaceFirst(" ", "")+"\n" ;
		}
	}
