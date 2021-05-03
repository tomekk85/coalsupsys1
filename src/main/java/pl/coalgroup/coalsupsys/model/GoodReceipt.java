package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class GoodReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @OneToOne
    Company contractor;
    int documentNumber;
    String suffix;
    LocalDate dateOfIssue;
    String issuer;//osoba wystawiająca


    @OneToMany(fetch = FetchType.EAGER)
    List<GoodReceiptItem> items = new ArrayList<>();
    public void addItem(GoodReceiptItem item){
        items.add(item);
    }
    public int getNumberOfItems(){
        return items.size();
    }

    @Override
    public String toString() {
        return "GoodReceipt{" +
                "Id=" + Id +
                ", contractor=" + contractor +
                ", documentNumber=" + documentNumber +
                ", suffix='" + suffix + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", issuer='" + issuer + '\'' +
                ", items=" + items +
                '}';
    }
}
