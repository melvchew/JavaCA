package model;

import javax.persistence.*;

@Entity
@Table(name="access_level")
public class AccessLevelDTO {

	@Id
	@Column(name="access_level_id")
	private int accessLevelId;
	@Column(name="access_level_name")
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
