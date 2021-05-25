package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Commodity commodity;

    private double amount;
}
