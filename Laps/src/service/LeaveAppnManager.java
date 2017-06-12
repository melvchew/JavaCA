package service;
import java.util.ArrayList;

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
}
