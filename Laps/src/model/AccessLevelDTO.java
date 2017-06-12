package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="access_level")
public class AccessLevelDTO {

	@Id
	@Column(name="access_level_id")
	private int accessLevelId;
	@Column(name="access_level_name")
	private String accessLevelName;
	
	@OneToMany(mappedBy="accessLevel")
	private List<PositionDTO> positions;

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

	public List<PositionDTO> getPositions() {
		return positions;
	}

	public void setPositions(List<PositionDTO> positions) {
		this.positions = positions;
	}


}
