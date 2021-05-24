package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class GoodsReceipt extends Document{

    @OneToOne
    private Supplier supplier;

    @Override
    public String toString() {
        return "GoodsReceipt{" +
                "Id=" + Id +
                ", dateOfIssue=" + dateOfIssue +
                ", supplier=" + supplier +
                ", issuer='" + issuer + '\'' +
                ", items=" + items +
                '}';
    }
}
