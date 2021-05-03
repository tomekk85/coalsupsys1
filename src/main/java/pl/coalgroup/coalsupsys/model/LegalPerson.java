package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class LegalPerson extends ContractorAbs {
    String firstName;
    String lastName;
    String PESEL;

    @Override
    public String toString() {
        return "LegalPerson{" +
                "id=" + id +
                ", isSupplier=" + isSupplier +
                ", isCustomer=" + isCustomer +
                ", address=" + address +
                ", phoneNo='" + phoneNo + '\'' +
                ", eMail='" + eMail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                '}';
    }
}
