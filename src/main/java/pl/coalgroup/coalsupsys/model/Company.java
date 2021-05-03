package pl.coalgroup.coalsupsys.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Company extends ContractorAbs {

    private String name;
    private String NIP;
    private String regon;
    private String bdo;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", NIP='" + NIP + '\'' +
                ", regon='" + regon + '\'' +
                ", bdo='" + bdo + '\'' +
                ", isSupplier=" + isSupplier +
                ", isCustomer=" + isCustomer +
                ", address=" + address +
                ", phoneNo='" + phoneNo + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }


}
