package pl.coalgroup.coalsupsys.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@ApiModel(description = "Details about the customer")
public class Customer extends CompanyAbs {

    @Override
    public String toString() {
        return "Customer{" +
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
