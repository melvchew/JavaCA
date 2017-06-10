package model;

import java.sql.Timestamp;

public class OtClaimsDTO {
	private int claimId;
	private int userId;
	private Timestamp claimDate;
	private String empComments;
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
