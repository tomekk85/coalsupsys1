package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.GoodsReceiptRegister;

public interface GRRegisterRepository extends JpaRepository<GoodsReceiptRegister, Long> {

}
