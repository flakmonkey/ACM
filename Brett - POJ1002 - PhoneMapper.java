import java.util.HashMap;
import java.util.Scanner;

public class PhoneMapper {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String input,output;
		int numLoops;
		Scanner scan = new Scanner(System.in);
		numLoops = scan.nextInt();
		for(int i=0; i<numLoops; i++) {
			input = scan.next();
			output = translate(input);
			if(map.containsKey(output))
				map.put(output,map.get(output)+1);
			else
				map.put(output, new Integer(1));	
		}
		
		for(String key : map.keySet()) {
			if(map.get(key) > 1)
				System.out.println(key + " " + map.get(key));
		}
	}
	
	public static String translate(String input) {
		String output = input.replaceAll("-", "");
		output = output.replaceAll("A|B|C", "2");
		output = output.replaceAll("D|E|F", "3");
		output = output.replaceAll("G|H|I", "4");
		output = output.replaceAll("J|K|L", "5");
		output = output.replaceAll("M|N|O", "6");
		output = output.replaceAll("P|R|S", "7");
		output = output.replaceAll("T|U|V", "8");
		output = output.replaceAll("W|X|Y", "9");
		output = output.substring(0, 3) + "-" + output.substring(3, 7);
		return output;
	}

}
