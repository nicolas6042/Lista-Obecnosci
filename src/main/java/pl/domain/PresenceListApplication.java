package pl.domain;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.domain.model.Employee;
import pl.domain.model.WorkHours;
import pl.domain.repository.EmployeeRepository;
import pl.domain.repository.WorkHoursRepository;

@SpringBootApplication
public class PresenceListApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(PresenceListApplication.class, args);
		
		EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
		Employee employee = new Employee("Jan", "Kowalski", "15-01-2018", "15-01-2018");
		Employee employee2 = new Employee("Marek", "Kowalski", "16-01-2018", "16-01-2018");
		employeeRepository.save(employee);
		employeeRepository.save(employee2);
		
		
		WorkHoursRepository workHoursRepository = ctx.getBean(WorkHoursRepository.class);
		WorkHours workHours = new WorkHours("7:00", "15:00");
		WorkHours workHours2 = new WorkHours("8:00", "16:00");
		workHours.setEmployee(employee);
		workHours2.setEmployee(employee2);
		workHoursRepository.save(workHours);
		workHoursRepository.save(workHours2);

		List<Employee> employeesList = employeeRepository.findAll();
		System.out.println(employeesList);
		
		// Uncomment to end program automatically
		//ctx.close();
	}
}
