import java.util.Scanner;

public class IThinkINeedAHouseboat {

	public static void main(String[] args) {
		int loops;
		double x, y;
		double radius, area;
		Scanner scan = new Scanner(System.in);
		
		loops = scan.nextInt();
		
		int[] years = new int[loops];
		
		for(int i=0; i<loops; i++) {
			x = scan.nextDouble();
			y = scan.nextDouble();
			
			radius = radius(x,y);
			area = area(radius);	
			years[i] = (int)((area/50)+1);
		}
		
		for(int i=0; i<loops; i++)		
			System.out.printf("Property %d: This property will begin " +
							  "eroding in year %d.\n", 
							  (i+1), years[i]);
		System.out.print("END OF OUTPUT.");
	}
	
	public static double radius(double x, double y) {
		double rad = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
		return rad;
	}
	
	public static double area(double rad) {
		double area = (Math.pow(rad,2) * 3.14159) / 2;
		return area;
	}

}
