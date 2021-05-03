package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coalgroup.coalsupsys.model.Address;
import pl.coalgroup.coalsupsys.model.LegalPerson;

public interface LegalPersonRepository extends JpaRepository<LegalPerson, Long> {
}
