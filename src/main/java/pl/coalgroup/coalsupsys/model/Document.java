package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@MappedSuperclass
@Table(name = "document")
@Data
public abstract class Document {
    Document(){
        currentPositionNumber = 1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;


    private int currentPositionNumber;
    LocalDate dateOfIssue;
    String issuer;//osoba wystawiająca


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    Map<Integer,Item> items = new HashMap<>();

    public void addItem(Commodity commodity, Double amount){
        Item item = new Item();
        item.setCommodity(commodity);
        item.setAmount(amount);

        items.put(currentPositionNumber++, item);
    }
    public int getNumberOfItems(){
        return items.size();
    }


    @Entity
    @Table(name = "item")
    @Data
    public static class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        @OneToOne
        Commodity commodity;
        private Double amount;
    }


}
