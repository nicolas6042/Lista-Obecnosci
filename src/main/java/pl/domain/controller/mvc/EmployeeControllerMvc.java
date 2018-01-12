package pl.domain.controller.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.domain.model.Employee;
import pl.domain.repository.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeControllerMvc {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeControllerMvc(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping
	public String listEmployees(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employeeList", employees);
		return "employee";
	}
	@PostMapping
	public String addEmployee(@ModelAttribute Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/";
	}
}
