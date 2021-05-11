package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class CompanyAbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String firstName;
    String lastName;
    String PESEL;

    String NIP;
    String regon;
    String bdo;

    String city;
    String zipcode;
    String street;
    int buildingNo;
    int localNo;

    String phoneNo;
    String eMail;

}
