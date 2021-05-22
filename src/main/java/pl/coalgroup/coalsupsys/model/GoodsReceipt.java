package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class GoodsReceipt extends Document{

    @OneToOne
    Supplier contractor;
    @Override
    public String toString() {
        return "GoodsReceipt{" +
                "Id=" + Id +
                ", contractor=" + contractor +
                ", dateOfIssue=" + dateOfIssue +
                ", issuer='" + issuer + '\'' +
                ", items=" + items +
                '}';
    }
}
