package pl.coalgroup.coalsupsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coalgroup.coalsupsys.model.DeliveryNote;

public interface DeliveryNoteRepository extends JpaRepository<DeliveryNote, Long> {

}
