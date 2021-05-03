package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.GoodReceipt;

public interface GoodReceiptRepository extends JpaRepository<GoodReceipt,Long> {
}
