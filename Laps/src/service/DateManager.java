package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {

	public Date createDate(String enteredDate){
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		try {
			date = df.parse(enteredDate);
		} catch (ParseException e) {
			System.out.println("Invalid format: " + enteredDate);
		}
		
		return date;
	}
}
