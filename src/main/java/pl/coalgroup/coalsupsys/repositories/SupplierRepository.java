package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
