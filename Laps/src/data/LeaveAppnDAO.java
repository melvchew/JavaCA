package data;

import java.util.ArrayList;

import model.LeaveAppnDTO;
import model.UsersDTO;

public interface LeaveAppnDAO {

	public void insertLeaveAppn(LeaveAppnDTO dto) throws DAOException;
	public void updateLeaveAppn(LeaveAppnDTO dto) throws DAOException; //reject and accept leaveappn
	public void deleteLeaveAppn(LeaveAppnDTO dto) throws DAOException; //change status column to deleted.
	public ArrayList<LeaveAppnDTO> getAllLeaveAppn() throws DAOException;
	public ArrayList<LeaveAppnDTO> getLeaveAppn(UsersDTO user) throws DAOException;
	public ArrayList<LeaveAppnDTO> getPendingLeaveAppn() throws DAOException;
	public LeaveAppnDTO getLeaveAppn(int leaveAppnId) throws DAOException;
}
