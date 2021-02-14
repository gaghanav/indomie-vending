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
public class Types {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String name;

    public Types(String name) {
        this.name = name;
    }

    public Types(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Types types = (Types) o;
        return Objects.equals(id, types.id) &&
                Objects.equals(name, types.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
