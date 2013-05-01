package manualcipher;

import java.util.*;

public class Cipher {
    private ArrayList<char[]> lookUp;
    private int[] key;
    
    public Cipher(String code, int key) {
        this.key = setKey(key);
        lookUp = setLookUp(code);
    }
    
    private int[] setKey(int key) {
        int [] newKey = new int[4];
        for(int i=(newKey.length-1); i>=0; i--) {
            newKey[(newKey.length-1)-i] = (key/(int)Math.pow(10,i)) % 10;
        }
        return newKey;
    }
    
    private ArrayList<char[]> setLookUp(String code) {
        ArrayList<char[]> lookUp = new ArrayList<char[]>();
        char cur;
        for(int i=0; i<code.length(); i++) {
            cur = code.charAt(i);
            lookUp.add(alphaArray(cur));
        }
        return lookUp;
    }
    
    private char[] alphaArray(char cur) {
        int length = 27;
        int base = 65;
        int offset = (int)cur - base;
        int after = length-offset-1;
        int before = offset-1;
        char[] result = new char[length];
        for(int i = 0; i<after; i++) {
            result[i] = (char)(offset+base+i);
        }
        result[after] = 32;
        for(int j=(after+1); j<length; j++) {
            result[j] = (char)(base+j-after-1);
        }
        return result;
    }
    
    public String decrypt(String input) {
        String result = "";
        int curKey = 0;
        int curLetter = 0;
        int size = input.length();
        while(curLetter < (size-1)) {
            for(int j=0; j<key[curKey]; j++) {
                result += decryptLetter(input.charAt(curLetter), curKey);
                if(curLetter < (size-1))
                    curLetter++;
                else
                    break;
            }
            if(curKey != (key.length-1))
                curKey++;
            else
                curKey = 0;
        }
        return result;
    }
    
    private String decryptLetter(char letter, int i) {
        int pos = 0;
        for(int j=0; j<27; j++) {
            if(letter == lookUp.get(i)[j]) {
                pos = j;
                break;
            }
        }
        String result = alphaPositionToString(pos);
        return result;
    }
    
    private String alphaPositionToString(int pos) {
        int base = 97;
        char alpha = (char)(pos+base);
        if(alpha == '{') 
            alpha = ' ';
        String result = Character.toString(alpha);
        return result;
    }
    
    public void print() {
        for(char[] i : lookUp) {
            for(char j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}