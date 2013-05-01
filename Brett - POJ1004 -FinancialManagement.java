import java.util.Scanner;

public class FinancialManagement {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String rawBalance;
		int intBal = 0;
		double avgBal;
		
		for(int i=0; i<12; i++) {
			rawBalance = scan.next();
			rawBalance = rawBalance.replaceAll("\\.", "");
			intBal += Integer.parseInt(rawBalance);
		}
		
		avgBal = (intBal / 100.00) / 12.00 ;
		System.out.print(avgBal);
	}

}
