/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnasorting.pkg1007;

/**
 *
 * @author flak
 */
import java.util.Scanner;
import dnasorting.pkg1007.DNASequence.*;
import dnasorting.pkg1007.DNAList.*;

public class DNASorting1007 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int count;
        Scanner scan = new Scanner(System.in);
        DNAList list = new DNAList();
        
        scan.next();
        count = scan.nextInt();
        
        for(int i=0; i < count; i++) {
            String dnaInput = scan.next();
            DNASequence sequence = new DNASequence(dnaInput);
            list.insert(sequence);
        }
        
        for(DNASequence item : list.list) {
            System.out.println(item.sequence + " " + item.sortedness);
        }
        
    }
}
