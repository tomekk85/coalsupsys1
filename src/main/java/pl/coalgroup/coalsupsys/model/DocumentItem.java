package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;


public abstract class DocumentItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    int position;//l.p. na dokumencie
    @OneToOne
    Commodity commodity;
    int amount;
}
