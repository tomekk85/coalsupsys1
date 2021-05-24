package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DeliveryNoteRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    DeliveryNote deliveryNote;
}
