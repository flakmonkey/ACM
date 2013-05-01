
import java.util.*;
import java.util.HashMap;

class Tzolkin {
    
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
        year = daysFromDay0 / 260;
        dayName = dayNames[daysFromDay0 % 20];
        day = (daysFromDay0 % 13) + 1;        
    }
    
}

class Haab {
    
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


class MayaCalendar1008 {

    public static void main(String[] args) {
        ArrayList<Tzolkin> convertedDates = new ArrayList<Tzolkin>();
        Scanner scan = new Scanner(System.in);
        int loops = scan.nextInt();
        
        for(int i=0; i<loops; i++) {
            int day = Integer.parseInt(scan.next().replaceAll("\\.", ""));
            String month = scan.next();
            int year = scan.nextInt();
            
            Haab input = new Haab(day,month.toUpperCase(),year);
            convertedDates.add(new Tzolkin(input.daysFromDay0));
        }
        
        System.out.println(convertedDates.size());
        for(Tzolkin output : convertedDates)
            System.out.println(output.day + " " + output.dayName.toLowerCase() +
                    " " + output.year);
    }
}
