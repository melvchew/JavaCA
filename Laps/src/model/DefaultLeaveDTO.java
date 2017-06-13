package model;

import javax.persistence.*;

import data.DefaultLeaveID;

@Entity
@IdClass(DefaultLeaveID.class)
@Table(name="default_leave")
public class DefaultLeaveDTO {

	@Id
	@Column(name="position_id")
	private int positionId;
	@Id
	@Column(name="leave_type_id")
	private int leaveTypeId;
	@Column(name="days")
	private int days;

	public DefaultLeaveDTO() {
		super();
	}

	public DefaultLeaveDTO(int positionId, int leaveTypeId, int days) {
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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

}
