package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
