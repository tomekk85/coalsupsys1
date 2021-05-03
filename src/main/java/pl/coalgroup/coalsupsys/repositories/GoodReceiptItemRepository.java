package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.GoodReceiptItem;

public interface GoodReceiptItemRepository extends JpaRepository<GoodReceiptItem, Long> {
}
