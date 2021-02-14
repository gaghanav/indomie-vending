package com.valentino.indomie.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "indomie_id")
    private Indomie indomie;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "transactions",
        joinColumns = @JoinColumn(name = "transaction_id"),
        inverseJoinColumns = @JoinColumn(name = "toping_id"))
    private List<Topings> topingsList;
    private Integer total;
    @Column(name = "trx_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date trxDate;

    public Transaction(Indomie indomie, List<Topings> topingsList, Integer total, Date trxDate) {
        this.indomie = indomie;
        this.topingsList = topingsList;
        this.total = total;
        this.trxDate = trxDate;
    }

    public Transaction(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(indomie, that.indomie) &&
                Objects.equals(topingsList, that.topingsList) &&
                Objects.equals(total, that.total) &&
                Objects.equals(trxDate, that.trxDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, indomie, topingsList, total, trxDate);
    }
}
