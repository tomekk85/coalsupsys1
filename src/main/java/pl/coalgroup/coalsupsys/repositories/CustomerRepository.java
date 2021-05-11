package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
