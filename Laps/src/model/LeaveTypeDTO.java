package model;

import javax.persistence.*;

@Entity
@Table(name="leave_types")
public class LeaveTypeDTO {

	@Id
	@Column(name="leave_type_id")
	private int leaveTypeId;
	@Column(name="leave_type")
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
