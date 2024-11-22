package co.pragra.learning.employedemo.repository;

import co.pragra.learning.employedemo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAddressRepo extends JpaRepository<EmployeeEntity, Long> {
}
