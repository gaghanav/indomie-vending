package com.valentino.indomie.entitys;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
public class Indomie {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "id_type")
    private Types type;
    private Integer prices;
    private String descriptions;

    public Indomie(String name, Types type, Integer prices, String descriptions) {
        this.name = name;
        this.type = type;
        this.prices = prices;
        this.descriptions = descriptions;
    }

    public Indomie(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indomie indomie = (Indomie) o;
        return Objects.equals(id, indomie.id) &&
                Objects.equals(name, indomie.name) &&
                Objects.equals(type, indomie.type) &&
                Objects.equals(prices, indomie.prices) &&
                Objects.equals(descriptions, indomie.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, prices, descriptions);
    }
}
