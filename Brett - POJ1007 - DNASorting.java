import java.util.Scanner;
import java.util.ArrayList;

class DNAList {
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

class DNASequence {
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

class DNASorting1007 {

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
            System.out.println(item.sequence);
        }
        
    }
}



