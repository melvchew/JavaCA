package data;

import java.util.ArrayList;

import model.LeaveDTO;
import model.LeaveTypeDTO;
import model.UsersDTO;

public interface LeaveDAO {

	public void insertLeave(LeaveDTO leave) throws Exception;
	public void updateLeave(LeaveDTO leave) throws Exception;
	public void deleteLeave(UsersDTO user) throws Exception;
	public ArrayList<LeaveDTO> getLeave(UsersDTO user) throws Exception;
	public LeaveDTO getLeaveByUser(UsersDTO user, LeaveTypeDTO leave) throws Exception;
}
