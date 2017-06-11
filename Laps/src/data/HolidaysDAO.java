package data;

import java.sql.Date;
import java.util.ArrayList;

import model.HolidaysDTO;

public interface HolidaysDAO {

	public void insertHoliday(HolidaysDTO dto) throws Exception;
	public void updateHoliday(HolidaysDTO dto) throws Exception;
	public void deleteHoliday(HolidaysDTO dto) throws Exception;
	public ArrayList<HolidaysDTO> getAllHolidays() throws Exception; 
	
}
