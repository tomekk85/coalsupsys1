package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coalgroup.coalsupsys.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
