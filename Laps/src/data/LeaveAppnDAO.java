package data;

import java.sql.Date;
import java.util.ArrayList;

import model.LeaveAppnDTO;
import model.UsersDTO;

public interface LeaveAppnDAO {

	public void insertLeaveAppn(LeaveAppnDTO dto) throws Exception;
	public void updateLeaveAppn(LeaveAppnDTO dto) throws Exception; //reject and accept leaveappn
	public void deleteLeaveAppn(LeaveAppnDTO dto) throws Exception; //change status column to deleted.
	public ArrayList<LeaveAppnDTO> getAllLeaveAppn(LeaveAppnDTO dto) throws Exception;
	public ArrayList<LeaveAppnDTO> getLeaveAppn(UsersDTO user) throws Exception;
	public ArrayList<LeaveAppnDTO> getPendingLeaveAppn() throws Exception;
}
