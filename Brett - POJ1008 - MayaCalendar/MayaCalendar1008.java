package mayacalendar.pkg1008;

import java.util.*;
import mayacalendar.pkg1008.Haab;
/**
 *
 * @author flak
 */
public class MayaCalendar1008 {

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
        
        for(Tzolkin output : convertedDates)
            System.out.println(output.day + " " + output.dayName.toLowerCase() +
                    " " + output.year);
    }
}
