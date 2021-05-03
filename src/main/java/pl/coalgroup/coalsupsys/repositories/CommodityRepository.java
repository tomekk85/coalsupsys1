package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {
}
