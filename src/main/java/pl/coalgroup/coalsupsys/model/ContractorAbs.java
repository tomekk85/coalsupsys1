package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class ContractorAbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    boolean isSupplier;
    boolean isCustomer;
    @OneToOne
    Address address;
    String phoneNo;
    String eMail;

}
