/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mayacalendar.pkg1008;

/**
 *
 * @author flak
 */
import java.util.HashMap;

public class Haab {
    
    public int daysFromDay0;
    private HashMap<String,Integer> monthValues;
    
    public Haab(int day, String month, int year) {
        setupCal();
        haabToInt(day, month, year);
    }
    
    private void setupCal() {
        monthValues = new HashMap<String,Integer>();
        monthValues.put("POP", 0);
        monthValues.put("NO", 1);
        monthValues.put("ZIP", 2);
        monthValues.put("ZOTZ", 3);
        monthValues.put("TZEC", 4);
        monthValues.put("XUL", 5);
        monthValues.put("YOXKIN", 6);
        monthValues.put("MOL", 7);
        monthValues.put("CHEN", 8);
        monthValues.put("YAX", 9);
        monthValues.put("ZAC", 10);
        monthValues.put("CEH", 11);
        monthValues.put("MAC", 12);
        monthValues.put("KANKIN", 13);
        monthValues.put("MUAN", 14);
        monthValues.put("PAX", 15);
        monthValues.put("KOYAB", 16);
        monthValues.put("CUMHU", 17);
        monthValues.put("UAYET", 18);
    }
    
    public void haabToInt(int day, String month, int year) {
        int monthVal = monthValues.get(month);
        daysFromDay0 = (year*365)+(monthVal*20)+day;
    }
}
