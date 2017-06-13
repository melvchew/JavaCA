package data;

import java.util.ArrayList;
import model.LeaveTypeDTO;

public interface LeaveTypeDAO {

	public LeaveTypeDTO getLeaveType(int LeaveTypeId) throws DAOException;
	public ArrayList<LeaveTypeDTO> getAllLeaveTypes() throws DAOException;
	public void insertLeaveType(LeaveTypeDTO lt) throws DAOException;
	public void updateLeaveType(LeaveTypeDTO lt) throws DAOException;

}
