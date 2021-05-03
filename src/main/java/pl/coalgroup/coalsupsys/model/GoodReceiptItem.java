package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class GoodReceiptItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    int position;//l.p. na dokumencie
    @OneToOne
    Commodity commodity;
    int amount;
}
