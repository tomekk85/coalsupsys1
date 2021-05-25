package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class GoodsReceiptRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    GoodsReceipt goodsReceipt;
}
