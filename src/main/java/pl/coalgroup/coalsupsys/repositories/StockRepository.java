package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
