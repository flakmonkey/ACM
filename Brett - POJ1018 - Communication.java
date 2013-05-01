package communication.pkg1018;

/**
 * @author flak
 */
import java.util.*;

public class Communication1018 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dataSets = scan.nextInt();
        int modules = scan.nextInt();
        int components;
        ArrayList<int[]> selections = new ArrayList<int[]>();
        String input;
        for(int i=0; i<dataSets; i++) {
            for(int j=0; j<modules; j++) {
                components = scan.nextInt();
                input = scan.nextLine();
                selections.add(selectModule(components, input));
            }
        }
        double result = calcMinRatio(selections);
        System.out.printf("%.2f\n",result);
    }
    
    public static int[] selectModule(int components, String input) {
        input = input.trim();
        String[] split = input.split(" ");
        int bandwidth, price;
        double ratio = Integer.MIN_VALUE;
        int[] result = new int[2];
        for(int i=0; i<components; i++) {
            bandwidth = Integer.parseInt(split[i*2]);
            price = Integer.parseInt(split[i*2+1]);
            if(ratio < (double)bandwidth/price) {
                ratio = (double)bandwidth / price;
                result[0] = bandwidth;
                result[1] = price;
            }
        }
        return result;
    }
    
    public static double calcMinRatio(ArrayList<int[]> input) {
        int totalPrice = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<input.size(); i++) {
            if(min > input.get(i)[0])
                min = input.get(i)[0];
        }
        for(int i=0; i<input.size(); i++) {
            totalPrice += input.get(i)[1];
        }
        double result = (double)min/totalPrice;
        return result;
    }
}
