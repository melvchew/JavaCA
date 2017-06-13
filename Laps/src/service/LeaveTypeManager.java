package service;
import data.DAOException;
import data.DAOFactory;
import data.LeaveTypeDAO;
import model.DefaultLeaveDTO;
import model.LeaveTypeDTO;

public class LeaveTypeManager {

	private LeaveTypeDAO leaveTypeDAO;
	
	public LeaveTypeManager(){
		leaveTypeDAO = DAOFactory.getLeaveType();
	}
	
	public LeaveTypeDTO getLeaveType(int LeaveTypeId) throws DAOException{
		return leaveTypeDAO.getLeaveType(LeaveTypeId);
	}
	

}
