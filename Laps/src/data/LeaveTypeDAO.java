package data;

import model.LeaveTypeDTO;

public interface LeaveTypeDAO {

	public LeaveTypeDTO getLeaveType(int LeaveTypeId) throws Exception;
}
