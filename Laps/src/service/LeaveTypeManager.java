package service;

import java.util.ArrayList;

import data.DAOException;
import data.DAOFactory;
import data.LeaveTypeDAO;
import model.DefaultLeaveDTO;
import model.LeaveTypeDTO;

public class LeaveTypeManager {

	private LeaveTypeDAO leaveTypeDAO;

	public LeaveTypeManager() {
		leaveTypeDAO = DAOFactory.getLeaveType();
	}

	public LeaveTypeDTO getLeaveType(int LeaveTypeId) throws DAOException {
		return leaveTypeDAO.getLeaveType(LeaveTypeId);
	}

	public ArrayList<LeaveTypeDTO> getAllLeaveTypes() throws DAOException {
		return leaveTypeDAO.getAllLeaveTypes();
	}
	
	public void updateLeavetype(LeaveTypeDTO lt) throws DAOException{
		leaveTypeDAO.updateLeaveType(lt);
	}

}
