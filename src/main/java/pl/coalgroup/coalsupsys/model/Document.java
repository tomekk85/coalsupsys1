package pl.coalgroup.coalsupsys.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Data
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long Id;
    protected LocalDate dateOfIssue;
    protected String issuer;//osoba wystawiająca

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Item> items = new ArrayList<>();

    public void addItem(Commodity commodity, Double amount){
        Item item = new Item();
        item.setCommodity(commodity);
        item.setAmount(amount);
        items.add(item);
    }

    @Entity
    @Data
    public static class Item {
        Item(){}

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        @OneToOne
        Commodity commodity;
        private Double amount;
    }


}
