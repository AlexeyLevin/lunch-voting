package ru.gkislin.voting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * User: gkislin
 */
@Entity
@Table(name = "restorant", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_restorant")})
public class Restorant extends NamedEntity {

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restorant")
    private Set<Menu> menus;

    public Restorant() {
    }

    public Restorant(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Restorant (" +
                "id=" + getId() +
                ", name=" + name +
                ')';
    }
}
