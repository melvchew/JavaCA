package model;

import java.sql.Timestamp;

public class UsersDTO {
	private int userId;
	private String username;
	private String password;
	private int positionId;
	private String name;
	private Timestamp dob;
	private String phone;
	private String address;
	private String email;
	private int managerId;
	private double otHours;

	public UsersDTO() {
		super();
	}

	public UsersDTO(int userId, String username, String password, int positionId, String name, Timestamp dob,
			String phone, String address, String email, int managerId, double otHours) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.positionId = positionId;
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

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
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
