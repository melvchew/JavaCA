package service;
import java.util.ArrayList;

import data.DAOFactory;
import data.LeaveDAO;
import model.LeaveDTO;
import model.LeaveTypeDTO;
import model.UsersDTO;

public class LeaveManager {

	private LeaveDAO leaveDAO;
	
	public LeaveManager(){
		leaveDAO = DAOFactory.getLeave();
	}
	
	public void insertLeave(LeaveDTO leave) throws Exception{
		leaveDAO.insertLeave(leave);
	}
	
	public void updateLeave(LeaveDTO leave) throws Exception{
		leaveDAO.updateLeave(leave);
	}
	public void deleteLeave(UsersDTO user) throws Exception{
		leaveDAO.deleteLeave(user);
	}
	public ArrayList<LeaveDTO> getLeave(UsersDTO user) throws Exception{
		return leaveDAO.getLeave(user);
	}
	
	public LeaveDTO getLeaveByUser(UsersDTO user, LeaveTypeDTO leave) throws Exception{
		return leaveDAO.getLeaveByUser(user,leave);
	}
}
