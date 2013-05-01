import java.math.*;
import java.util.Scanner;

public class Exponentiation {

	public static void main(String[] args) {
		String base;
		int exp;
		String result;
		
		Scanner scan = new Scanner(System.in);

		base = scan.next();
		exp = scan.nextInt();
		
		BigDecimal bigDec = new BigDecimal(base);
		
		result = format(bigDec.pow(exp).toPlainString());
		
		System.out.println(result);
	}
	
	public static String format(String bigDec) {
		if(bigDec.charAt(0) == '0')
			bigDec = bigDec.substring(1);
		while(bigDec.charAt(bigDec.length()-1) == '0') {
			bigDec = bigDec.substring(0, bigDec.length()-1);
		}
		return bigDec;
	}
}
