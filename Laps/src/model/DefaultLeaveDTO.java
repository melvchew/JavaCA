package model;

public class DefaultLeaveDTO {

	private int positionId;
	private int leaveTypeId;
	private double days;

	public DefaultLeaveDTO() {
		super();
	}

	public DefaultLeaveDTO(int positionId, int leaveTypeId, double days) {
		super();
		this.positionId = positionId;
		this.leaveTypeId = leaveTypeId;
		this.days = days;
	}

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

	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}

}
