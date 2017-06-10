package model;

import java.sql.Timestamp;

public class LeaveAppnDTO {

	private int appnId;
	private int leaveTypeId;
	private int userId;
	private Timestamp appnDate;
	private Timestamp startDate;
	private Timestamp endDate;
	private String empComments;
	private String mgrComments;
	private String status;

	public LeaveAppnDTO() {
		super();
	}

	public LeaveAppnDTO(int appnId, int leaveTypeId, int userId, Timestamp appnDate, Timestamp startDate,
			Timestamp endDate, String empComments, String mgrComments, String status) {
		super();
		this.appnId = appnId;
		this.leaveTypeId = leaveTypeId;
		this.userId = userId;
		this.appnDate = appnDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.empComments = empComments;
		this.mgrComments = mgrComments;
		this.status = status;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getAppnDate() {
		return appnDate;
	}

	public void setAppnDate(Timestamp appnDate) {
		this.appnDate = appnDate;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getEmpComments() {
		return empComments;
	}

	public void setEmpComments(String empComments) {
		this.empComments = empComments;
	}

	public String getMgrComments() {
		return mgrComments;
	}

	public void setMgrComments(String mgrComments) {
		this.mgrComments = mgrComments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAppnId() {
		return appnId;
	}

}
