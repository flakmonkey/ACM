package atlaspagination;

/**
 * @author flak
 */
import java.util.*;

public class Map {
    private ArrayList<int[]> map;
    public int dimx;
    public int dimy;
    
    public Map(int dimx, int dimy) {
        this.dimx = dimx;
        this.dimy = dimy;
        setMapFromInput(dimy);
        numberMap();
    }
    
    private void setMapFromInput(int dimy) {
        Scanner scan = new Scanner(System.in);
        ArrayList<int[]> map = new ArrayList<int[]>();
        String line;

        for(int i=0; i<dimy; i++) {
            line = scan.nextLine();
            map.add(translateLine(line));
        }
        this.map = map;
    }
    
    private static int[] translateLine(String line) {
        line = line.replace(".","1");
        line = line.replace("X", "0");
        int[] result = new int[line.length()];
        for(int i=0; i<result.length; i++) {
            result[i] = Integer.parseInt(line.substring(i, i+1));
        }
        return result;
    }
    
    private void numberMap() {
        int count = 1;
        for(int i=0; i<map.size(); i++) {
            for(int j=0; j<map.get(i).length; j++) {
                if(map.get(i)[j] == 1)
                {
                    map.get(i)[j] = count;
                    count++;
                }
            }
        }    
    }
    
    public ArrayList<int[]> neighborMap() {
        ArrayList<int[]> results = new ArrayList<int[]>();
        int[] neighbors;
        for(int i=0; i<map.size(); i++) {
            for(int j=0; j<map.get(i).length; j++) {
                if(map.get(i)[j] != 0) {
                    neighbors = findNeighbors(map, j, i, dimx, dimy);
                    results.add(neighbors);
                }
            }
        }
        return results;
    }
    
    
    private int[] findNeighbors(ArrayList<int[]> map, int x, int y, 
                                      int dimx, int dimy) 
    {
        int t = findTop(map,x,y);
        int r = findRight(map,x,y,dimx);
        int b = findBottom(map,x,y,dimy);
        int l = findLeft(map,x,y);
        int[] result = new int[]{ map.get(y)[x],t,r,b,l};
        return result;
    }
    
    private  int findTop(ArrayList<int[]> map, int x, int y) {
        if(y>0)
            return map.get(y-1)[x];
        else
            return 0;
    }
     
    private int findBottom(ArrayList<int[]> map, int x, int y, int dimy) {
        if(y<(dimy-1))
            return map.get(y+1)[x];
        else
            return 0;
    }
    
    private int findLeft(ArrayList<int[]> map, int x, int y) {
        if(x>0)
            return map.get(y)[x-1];
        else
            return 0;
    }
    
    private int findRight(ArrayList<int[]> map, int x, int y, int dimx) {
        if(x<(dimx-1))
            return map.get(y)[x+1];
        else
            return 0;
    }
    
}
