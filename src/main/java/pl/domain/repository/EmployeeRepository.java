package pl.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.domain.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
