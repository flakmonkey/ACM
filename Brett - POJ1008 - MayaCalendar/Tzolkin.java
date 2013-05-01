/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mayacalendar.pkg1008;

/**
 *
 * @author flak
 */

public class Tzolkin {
    
    private String[] dayNames;
    public int day;
    public String dayName;
    public int year;
    
    public Tzolkin(int daysFromDay0) {
        dayNames = new String[] {
            "IMIX", "IK", "AKBAL", "KAN", "CHICCHAN", "CIMI", "MANIK", "LAMAT", 
            "MULUK", "OK", "CHUEN", "EB", "BEN", "IX", "MEM", "CIB", "CABAN", 
            "EZNAB", "CANAC", "AHAU"
        };
        intToTzolkin(daysFromDay0);
    }
    
    
    public void intToTzolkin(int daysFromDay0) {
        //year = 260 days
        //# years = input / 260 (integer division)
        //dayname = array of names [input % 20]
        //day number = (input % 13) + 1
        year = daysFromDay0 / 260;
        dayName = dayNames[daysFromDay0 % 20];
        day = (daysFromDay0 % 13) + 1;        
    }
    
}
