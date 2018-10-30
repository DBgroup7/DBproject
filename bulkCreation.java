import java.lang.Math;
public class bulkCreation {
	public static void main (String [] args) {
		
		int gameID = 100000;
		
		String stadiums[] = new String []{"AT&T", "New Era Field",
                              "EverBank Field", "Nissan Field", "FedEx Field"};
        String result[] = new String[] {"W", "L", "T"};
        
        int monthRange = (12 - 1) + 1;
        int yearRange = (2018 - 2010) + 1;
        int dayRange = (28 - 1) + 1;
        int resultRange = 3;
        int stadiumRange = 5;
        int attendRange= (850000 - 10000) + 1;
        int ticketRange = (850000 - 10000) + 1;
        
        
        int tempMonth, tempYear, tempDay, tempResult, tempStadium;
        int tempAttendance, tempTicket;
                              
		for (int z = 0; z < 100000; z++)
		{
            tempYear = (int)(Math.random() * yearRange) + 2010;
			tempMonth = (int)(Math.random() * monthRange) + 1;
			tempDay = (int)(Math.random() * dayRange) + 1;
			tempResult = (int)(Math.random() * resultRange);
			tempStadium = (int)(Math.random() * stadiumRange);
			tempAttendance = (int)(Math.random() * attendRange) + 10000;
			tempTicket = (int)(Math.random() * ticketRange) + 10000;
			
			
        
			
			System.out.println(gameID + ", \'" + tempYear + "-" + tempMonth + "-" + tempDay + "\', \'" + stadiums[tempStadium]
                                 + "\' , \'" + result[tempResult] + "\', " + tempAttendance + ", " + tempTicket
                                 + ")");
                                 
			gameID++;
		}
		
		
		
		
		
		
	}
}
