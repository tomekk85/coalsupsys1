package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coalgroup.coalsupsys.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
