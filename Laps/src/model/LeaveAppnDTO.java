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
	
	//@Column(name="leave_type_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="leave_type_id")
	private LeaveTypeDTO leaveType;
	
	//@Column(name="user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UsersDTO user;
	
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

	public LeaveAppnDTO(int appnId, LeaveTypeDTO leaveType, UsersDTO user, Date appnDate, Date startDate,
			Date endDate, String empComments, String mgrComments, String status) {
		super();
		this.appnId = appnId;
		this.leaveType = leaveType;
		this.user = user;
		this.appnDate = appnDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.empComments = empComments;
		this.mgrComments = mgrComments;
		this.status = status;
	}

	public LeaveTypeDTO getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveTypeDTO leaveType) {
		this.leaveType = leaveType;
	}

	public UsersDTO getUser() {
		return user;
	}

	public void setUser(UsersDTO user) {
		this.user = user;
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

	public void setAppnId(int id) {
		this.appnId = id;
	}
	
}
