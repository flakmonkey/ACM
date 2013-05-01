/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnasorting.pkg1007;

/**
 *
 * @author flak
 */
public class DNASequence {
    public String sequence;
    public int sortedness;
    
    public DNASequence(String sequence) {
        this.sequence = sequence;
        calcSortedness();
    }
    
    private void calcSortedness() {
        int curSortedness = 0;
        char curChar;
        for(int i=0; i<sequence.length(); i++) {
            curChar = sequence.charAt(i);
            for(int j=(i+1); j<sequence.length(); j++) {
                if(curChar > sequence.charAt(j))
                    curSortedness++;
            }              
        }
        sortedness = curSortedness;
    }
}
