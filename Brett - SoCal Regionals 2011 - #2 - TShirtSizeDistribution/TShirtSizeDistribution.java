package tshirtsizedistribution;

/**
 * @author flak
 */
import java.util.*;

public class TShirtSizeDistribution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = new int[8];
        while(true) {
            for(int i=0; i<input.length; i++)
                input[i] = scan.nextInt();
            TShirtOrder order = new TShirtOrder(input);
            order.printOrder();
        }
    }
}
