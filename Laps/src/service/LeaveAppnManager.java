package service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.DAOException;
import data.DAOFactory;
import data.LeaveAppnDAO;
import model.LeaveAppnDTO;
import model.UsersDTO;

public class LeaveAppnManager {

	private LeaveAppnDAO leaveAppnDAO;
	
	public LeaveAppnManager(){
		leaveAppnDAO = DAOFactory.getLeaveAppn();
	}
	public void insertLeaveAppn(LeaveAppnDTO dto) throws DAOException{
		leaveAppnDAO.insertLeaveAppn(dto);
	}
	public void updateLeaveAppn(LeaveAppnDTO dto) throws DAOException{
		leaveAppnDAO.updateLeaveAppn(dto);
	}
	public void deleteLeaveAppn(LeaveAppnDTO dto) throws DAOException{
		leaveAppnDAO.deleteLeaveAppn(dto);
	}
	public ArrayList<LeaveAppnDTO> getAllLeaveAppn() throws DAOException{
		return leaveAppnDAO.getAllLeaveAppn();
	}
	public ArrayList<LeaveAppnDTO> getLeaveAppn(UsersDTO user) throws DAOException{
		return leaveAppnDAO.getLeaveAppn(user);
	}
	public ArrayList<LeaveAppnDTO> getPendingLeaveAppn() throws DAOException{
		return leaveAppnDAO.getPendingLeaveAppn();
	}
	public LeaveAppnDTO getLeaveAppn(int leaveAppnId) throws DAOException{
		return leaveAppnDAO.getLeaveAppn(leaveAppnId);
	}
	
	public int getNumberOfLeaveDays(Date startDate, Date endDate) throws Exception{
			if (endDate.before(startDate)) {
				return -1;  // throw dateInverseException
			}
			HolidayManager hm = new HolidayManager();
			int dayDiff = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24)) + 1; // +1 because it is inclusive
			
			if(dayDiff <= 14){
				return dayDiff;
			} else {
				Calendar cal = Calendar.getInstance();
				cal.setTime(startDate);
				int days = dayDiff;
				for (int i = 0; i < days; i++) {
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||  hm.isHoliday(cal.getTime())){
						dayDiff -= 1;
					}
					cal.add(Calendar.DATE, 1);
				}
			}
		return dayDiff;
	}
}
