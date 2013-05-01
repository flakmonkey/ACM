
import java.util.*;

public class NumbersThatCount {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numbCount;
		String result;
		String input;
		boolean quit = false;
		int steps;
		
		while(!quit) {
			input = scan.next();
			steps = stepsToInventory(input);
			if(steps != 0) 
				System.out.println(input + " is self-inventorying after " + steps + " steps");
			else
				System.out.println("Unable to inventory");
		}
	}
	
	static int[] countDigits(String input) {
		int[] numbCount = new int[10];
		for(int i=0; i<numbCount.length; i++) { numbCount[i] = 0; }
		
		int curNumb;
		for(int i=0; i<input.length(); i++) {
			curNumb = Character.getNumericValue(input.charAt(i));
			numbCount[curNumb] += 1; 
		}
		return numbCount;
	}
	
	static String calcInventory(int[] numbCount) {
		String result = "";
		for(int i=0; i<numbCount.length; i++) {
			if(numbCount[i] != 0)
				result += (numbCount[i] + "" + i);
		}
		return result;
	}
	
	static int stepsToInventory(String input) {
		int[] numbCount;
		String result = input;
		String previous = "";
		int i = 0;
		
		while(i<15) {
			previous = new String(result);
			numbCount = countDigits(result);
			result = calcInventory(numbCount);
			i++;
			if(result.equals(previous))
				if(i == 1)
					return i;
				else
					return (i-1);
		}
		
		return 0;
	}
}