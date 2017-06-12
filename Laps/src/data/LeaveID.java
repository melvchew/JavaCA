package data;

import java.io.Serializable;

public class LeaveID implements Serializable {

	private static final long serialVersionUID = 1L;

	private int userId;
	private int leaveTypeId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + leaveTypeId;
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaveID other = (LeaveID) obj;
		
		if (leaveTypeId != other.leaveTypeId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
}