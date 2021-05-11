package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Supplier extends CompanyAbs {
    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", NIP='" + NIP + '\'' +
                ", regon='" + regon + '\'' +
                ", bdo='" + bdo + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", street='" + street + '\'' +
                ", buildingNo=" + buildingNo +
                ", localNo=" + localNo +
                ", phoneNo='" + phoneNo + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
