import java.util.Scanner;
import java.util.ArrayList;

public class Hangover {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> results = new ArrayList<Integer>();
		float input;
		boolean done = false;
		while(done == false) {
			input = overhang(scan.nextFloat());
			if(input == 0)
				done = true;
			else
				results.add((int)input);
		}
		
		for(int item : results) {
			System.out.println(item + " card(s)");
		}
	}
	
	public static float overhang(float maxLen) {
		float curLen = 0;
		int count = 0;
		while(curLen < maxLen) {
			curLen += 1.0 / (count + 2);
			count++;
		}
		return count;
	}

}
