package atlaspagination;

/**
 * @author flak
 */
import java.util.*;

public class AtlasPagination {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Map> mapBag = new ArrayList<Map>();
        int dimx;
        int dimy;        
        while(true) {
            dimx = scan.nextInt();
            dimy = scan.nextInt();
            if(dimx == 0 || dimy == 0)
                break;
            mapBag.add(new Map(dimy, dimx));
        }
        
        ArrayList<int[]> result;
        for(Map map : mapBag) {
            result = map.neighborMap();
            for(int[] row : result) {
                for(int numb : row) {
                    System.out.print(numb + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
    }
}