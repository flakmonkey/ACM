import java.util.Scanner;

public class Biorhythms {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		int e = scan.nextInt();
		int i = scan.nextInt();
		int d = scan.nextInt();
		
		System.out.println(lcm(lcm(23+p,28+e),33+i)-d);
	}
	
	public static int gcd(int x, int y) {
		int remainder = x % y;
		
		if(remainder != 0)
			return gcd(y,remainder);
		else
			return y;
	}
	
	public static int lcm(int x, int y) {
		int lcm = Math.abs(x*y) / gcd(x,y);
		return lcm;
	}
}
