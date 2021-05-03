package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;
    private double price;
    private Unit unit;

    public enum Unit {
        szt, kg, t, m, m2, m3
    }
}
