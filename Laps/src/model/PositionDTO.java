package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="position")
public class PositionDTO {
	
	@Id
	@Column(name="position_id")
	private int positionId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="access_level_id")
	private AccessLevelDTO accessLevel;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@OneToMany(mappedBy="position")
	private List<UsersDTO> users;

	public PositionDTO() {
		super();
	}

	public PositionDTO(int positionId, AccessLevelDTO accessLevel, String jobTitle) {
		super();
		this.positionId = positionId;
		this.accessLevel = accessLevel;
		this.jobTitle = jobTitle;
	}

	public List<UsersDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UsersDTO> users) {
		this.users = users;
	}

	public AccessLevelDTO getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevelDTO accessLevel) {
		this.accessLevel = accessLevel;
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
