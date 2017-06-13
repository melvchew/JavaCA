package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import data.DAOFactory;
import data.HolidaysDAO;
import model.HolidaysDTO;

public class HolidayManager {

private HolidaysDAO holidaysDAO;
	
	public HolidayManager(){
		holidaysDAO = DAOFactory.getHolidaysDAOInstance();
	}
	
	public void insertHoliday(HolidaysDTO dto) throws Exception{
		holidaysDAO.insertHoliday(dto);
	}
	public void updateHoliday(HolidaysDTO dto) throws Exception{
		holidaysDAO.updateHoliday(dto);
	}
	public void deleteHoliday(HolidaysDTO dto) throws Exception{
		holidaysDAO.deleteHoliday(dto);
	}
	public ArrayList<HolidaysDTO> getAllHolidays() throws Exception{
		return holidaysDAO.getAllHolidays();
	}
	
	public HolidaysDTO findHolidayBydate(Timestamp date) throws Exception{
		
		return holidaysDAO.findHolidayBydate(date);
	}
	
}
