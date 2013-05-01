/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnasorting.pkg1007;

/**
 *
 * @author flak
 */

import java.util.ArrayList;
import dnasorting.pkg1007.DNASequence.*;

public class DNAList {
    public ArrayList<DNASequence> list;
    
    public DNAList() {
        list = new ArrayList<DNASequence>();
    }
    
    public void insert(DNASequence sequence) {
        int count = 0;
        
        if(list.isEmpty())
            list.add(sequence);
        else {
            while(sequence.sortedness >= list.get(count).sortedness) {
                count++;
                if(count >= list.size()) 
                    break;
            }
            if(count >= list.size()) 
                list.add(sequence);
            else
                list.add(count,sequence);
        }
    }
}
