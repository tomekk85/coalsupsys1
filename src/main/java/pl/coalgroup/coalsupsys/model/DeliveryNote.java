package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class DeliveryNote extends Document{
    @OneToOne
    Customer customer;

    @Override
    public String toString() {
        return "DeliveryNote{" +
                "Id=" + Id +
                ", dateOfIssue=" + dateOfIssue +
                ", customer=" + customer +
                ", issuer='" + issuer + '\'' +
                ", items=" + items +
                '}';
    }
}
