package pl.coalgroup.coalsupsys.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @OneToOne
    Customer contractor;
    int documentNumber;
    String suffix;
    LocalDate dateOfIssue;
    String issuer;//osoba wystawiająca

    @OneToMany
    List<DocumentItem> items = new ArrayList<>();
    public void addItem(DocumentItem item){
        items.add(item);
    }
    public void removeItem(DocumentItem item){
        items.remove(item);
    }
}
