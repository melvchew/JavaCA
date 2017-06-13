package data;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.HolidaysDTO;

public interface HolidaysDAO {

	public void insertHoliday(HolidaysDTO dto) throws Exception;
	
	public void updateHoliday(HolidaysDTO dto) throws Exception;
	
	public void deleteHoliday(HolidaysDTO dto) throws Exception;
	
	public ArrayList<HolidaysDTO> getAllHolidays() throws Exception; 
	
	public HolidaysDTO findHolidayBydate(Timestamp date) throws Exception;
}
