package model;

public class LeaveDTO {

	private int userId;
	private int leaveTypeId;
	private double daysRemaining;

	public LeaveDTO() {
		super();
	}

	public LeaveDTO(int userId, int leaveTypeId, double daysRemaining) {
		super();
		this.userId = userId;
		this.leaveTypeId = leaveTypeId;
		this.daysRemaining = daysRemaining;
	}

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

	public double getDaysRemaining() {
		return daysRemaining;
	}

	public void setDaysRemaining(double daysRemaining) {
		this.daysRemaining = daysRemaining;
	}

}
