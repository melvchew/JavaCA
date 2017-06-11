package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="position")
public class PositionDTO {
	
	@Id
	@Column(name="position_id")
	private int positionId;
	@Column(name="access_level_id")
	private int accessLevelId;
	@Column(name="job_title")
	private String jobTitle;

	public PositionDTO() {
		super();
	}

	public PositionDTO(int positionId, int accessLevelId, String jobTitle) {
		super();
		this.positionId = positionId;
		this.accessLevelId = accessLevelId;
		this.jobTitle = jobTitle;
	}

	public int getAccessLevelId() {
		return accessLevelId;
	}

	public void setAccessLevelId(int accessLevelId) {
		this.accessLevelId = accessLevelId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getPositionId() {
		return positionId;
	}

}
