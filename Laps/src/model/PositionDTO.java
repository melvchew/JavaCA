package model;

public class PositionDTO {
	private int positionId;
	private int accessLevelId;
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
