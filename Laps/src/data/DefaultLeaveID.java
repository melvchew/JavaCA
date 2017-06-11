package data;

import java.io.Serializable;

public class DefaultLeaveID implements Serializable {

	private static final long serialVersionUID = 1L;

	private int positionId;
	private int leaveTypeId;

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
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
		result = prime * result + positionId;
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
		DefaultLeaveID other = (DefaultLeaveID) obj;
		if (leaveTypeId != other.leaveTypeId)
			return false;
		if (positionId != other.positionId)
			return false;
		return true;
	}

}
