package com.valentino.indomie.entitys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter @Setter
public class Topings {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String name;
    private Integer price;
    private String descriptions;

    public Topings(String name, Integer price, String descriptions) {
        this.name = name;
        this.price = price;
        this.descriptions = descriptions;
    }

    public Topings(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topings topings = (Topings) o;
        return Objects.equals(id, topings.id) &&
                Objects.equals(name, topings.name) &&
                Objects.equals(price, topings.price) &&
                Objects.equals(descriptions, topings.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, descriptions);
    }
}
