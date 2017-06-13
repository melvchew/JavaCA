package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="holidays")
public class HolidaysDTO {
	
@Id
@Temporal(TemporalType.TIMESTAMP)
	private Date date; 
@Column
	private String description;

	public HolidaysDTO() {
		super();
	}

	public HolidaysDTO(Date date, String description) {
		super();
		this.date = date;
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}