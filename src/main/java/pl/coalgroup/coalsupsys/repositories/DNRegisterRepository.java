package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.DeliveryNoteRegister;

public interface DNRegisterRepository extends JpaRepository<DeliveryNoteRegister,Long> {

}
