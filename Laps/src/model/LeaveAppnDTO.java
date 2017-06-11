package model;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="leave_appn")
public class LeaveAppnDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="appn_id")
	private int appnId;
	@Column(name="leave_type_id")
	private int leaveTypeId;
	@Column(name="user_id")
	private int userId;
	@Column(name="appn_date")
	private Date appnDate;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="emp_comments")
	private String empComments;
	@Column(name="mgr_comments")
	private String mgrComments;
	private String status;

	public LeaveAppnDTO() {
		super();
	}

	public LeaveAppnDTO(int appnId, int leaveTypeId, int userId, Date appnDate, Date startDate,
			Date endDate, String empComments, String mgrComments, String status) {
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

	public Date getAppnDate() {
		return appnDate;
	}

	public void setAppnDate(Date appnDate) {
		this.appnDate = appnDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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
