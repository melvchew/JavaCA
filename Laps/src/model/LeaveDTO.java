package model;


import javax.persistence.*;

import data.LeaveID;


@Entity @IdClass(LeaveID.class)
@Table(name="`leave`")
public class LeaveDTO {
	@Id
	@Column(name="user_id")
	private int userId;
	@Id
	@Column(name="leave_type_id")
	private int leaveTypeId;
	@Column(name="days_remaining")
	private double daysRemaining;
	
	@Transient
	private UsersDTO user;

	@Transient
	private LeaveTypeDTO leaveType;

	public LeaveDTO() {
		super();
	}

	public LeaveDTO(int userId, int leaveTypeId, double daysRemaining) {
		super();
		this.userId = userId;
		this.leaveTypeId = leaveTypeId;
		this.daysRemaining = daysRemaining;
	}

	public UsersDTO getUser() {
		return user;
	}

	public void setUser(UsersDTO user) {
		this.user = user;
	}

	public LeaveTypeDTO getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveTypeDTO leaveType) {
		this.leaveType = leaveType;
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
