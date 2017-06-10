package model;

public class LeaveTypeDTO {
	private int leaveTypeId;
	private String leaveType;

	public LeaveTypeDTO() {
		super();
	}

	public LeaveTypeDTO(int leaveTypeId, String leaveType) {
		super();
		this.leaveTypeId = leaveTypeId;
		this.leaveType = leaveType;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

}
