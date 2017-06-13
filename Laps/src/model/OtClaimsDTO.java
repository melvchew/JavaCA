package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ot_claims")
public class OtClaimsDTO {
	@Id
	@Column(name="claim_id")
	private int claimId;
	@Column(name="user_id")
	private int userId;
	@Column(name="claim_date")
	private Timestamp claimDate;
	@Column(name="emp_comments")
	private String empComments;
	@Column(name="mgr_comments")
	private String mgrComments;
	private String status;

	public OtClaimsDTO() {
		super();
	}

	public OtClaimsDTO(int claimId, int userId, Timestamp claimDate, String empComments, String mgrComments,
			String status) {
		super();
		this.claimId = claimId;
		this.userId = userId;
		this.claimDate = claimDate;
		this.empComments = empComments;
		this.mgrComments = mgrComments;
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Timestamp claimDate) {
		this.claimDate = claimDate;
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

	public int getClaimId() {
		return claimId;
	}

}
