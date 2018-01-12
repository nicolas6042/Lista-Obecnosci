package pl.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement
@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = 3845249751081817500L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "entry_date")
	private String entryDate;
	@Column(name = "exit_date")
	private String exitDate;
	@Column(name = "entry_time")
	private String entryTime;
	@Column(name = "exit_time")
	private String exitTime;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String entryDate, String exitDate, String entryTime,
			String exitTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

}
