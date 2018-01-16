package pl.domain.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.domain.model.Employee;
import pl.domain.model.WorkHours;
import pl.domain.repository.EmployeeRepository;
import pl.domain.repository.WorkHoursRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControllerRest {

	private EmployeeRepository employeeRepository;
	private WorkHoursRepository workHoursRepository;

	@Autowired
	public EmployeeControllerRest(EmployeeRepository employeeRepository, WorkHoursRepository workHoursRepository) {
		this.employeeRepository = employeeRepository;
		this.workHoursRepository = workHoursRepository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeesList() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable Long id) {
		return employeeRepository.findOne(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);

	}
	@PostMapping(path = "/{id}/addWorkHours",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addWorkHours(@RequestBody WorkHours workHours, @PathVariable Long id) {
		workHours.setEmployee(getEmployee(id));
		workHoursRepository.save(workHours);

	}

}
