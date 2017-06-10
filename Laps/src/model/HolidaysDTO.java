package model;

import java.sql.Timestamp;

public class HolidaysDTO {

	private Timestamp date; //TIMESTAMP OR??
	private String description;

	public HolidaysDTO() {
		super();
	}

	public HolidaysDTO(Timestamp date, String description) {
		super();
		this.date = date;
		this.description = description;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
