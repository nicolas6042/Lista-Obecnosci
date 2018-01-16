package pl.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity
@Table(name = "work_hours")
public class WorkHours implements Serializable {
	private static final long serialVersionUID = -623763992509727737L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "entry_time")
	private String entryTime;
	@Column(name = "exit_time")
	private String exitTime;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public WorkHours() {
	}

	public WorkHours(String entryTime, String exitTime) {
		this.entryTime = entryTime;
		this.exitTime = exitTime;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "WorkHours [entryTime= " + entryTime + ", exitTime= " + exitTime + "]";
	}
}
