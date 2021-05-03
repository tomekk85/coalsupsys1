package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class DocumentItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    protected long id;
    int position;//l.p. na dokumencie
    @OneToOne
    Commodity commodity;
    int amount;
}
