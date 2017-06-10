package model;

public class AccessLevelDTO {

	private int accessLevelId;
	private String accessLevelName;

	public AccessLevelDTO() {
		super();
	}

	public AccessLevelDTO(int accessLevelId, String accessLevelName) {
		super();
		this.accessLevelId = accessLevelId;
		this.accessLevelName = accessLevelName;
	}

	public int getAccessLevelId() {
		return accessLevelId;
	}

	public void setAccessLevelId(int accessLevelId) {
		this.accessLevelId = accessLevelId;
	}

	public String getAccessLevelName() {
		return accessLevelName;
	}

	public void setAccessLevelName(String accessLevelName) {
		this.accessLevelName = accessLevelName;
	}

}
