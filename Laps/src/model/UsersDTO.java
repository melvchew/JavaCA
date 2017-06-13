package model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="users")
public class UsersDTO {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	private String username;
	private String password;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="position_id")
	private PositionDTO position;
	
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	private String phone;
	private String address;
	private String email;
	@Column(name="manager_id")
	private int managerId;
	@Column(name="ot_hours")
	private double otHours;
	
	@OneToMany(mappedBy = "leaveType")
	private List<LeaveAppnDTO> leaveAppns;
	

	public List<LeaveAppnDTO> getLeaveAppns() {
		return leaveAppns;
	}

	public void setLeaveAppns(List<LeaveAppnDTO> leaveAppns) {
		this.leaveAppns = leaveAppns;
	}

	public UsersDTO() {
		super();
	}

	public UsersDTO(int userId, String username, String password, PositionDTO position, String name, Date dob,
			String phone, String address, String email, int managerId, double otHours) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.position = position;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.managerId = managerId;
		this.otHours = otHours;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public double getOtHours() {
		return otHours;
	}

	public void setOtHours(double otHours) {
		this.otHours = otHours;
	}

	public int getUserId() {
		return userId;
	}

}
