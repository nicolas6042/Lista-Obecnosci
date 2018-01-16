package pl.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.domain.model.WorkHours;
@Repository
@Transactional
public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {

}
