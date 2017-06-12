package service;

import java.util.ArrayList;

import data.DAOFactory;
import data.HolidaysDAO;
import model.HolidaysDTO;

public class HolidayManager {

	private HolidaysDAO holidaysDAO;
	
	public HolidayManager(){
		holidaysDAO = DAOFactory.getHolidays();
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
}
