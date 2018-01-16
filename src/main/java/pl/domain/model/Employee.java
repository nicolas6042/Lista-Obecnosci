package pl.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@Column(name = "entry_date")
	private String entryDate;
	@Column(name = "exit_date")
	private String exitDate;
	@JsonManagedReference
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
	private List<WorkHours> workHours;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String entryDate, String exitDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
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

	public List<WorkHours> getWorkHours() {
		return workHours;
	}

	public void setWorkHours(List<WorkHours> workHours) {
		this.workHours = workHours;
	}

	@Override
	public String toString() {
		return "Employee [id= " + id + ", firstName= " + firstName + ", lastName= " + lastName + ", entryDate= " + entryDate
				+ ", exitDate= " + exitDate + " workHours= " + workHours + "]\n";
	}
}
