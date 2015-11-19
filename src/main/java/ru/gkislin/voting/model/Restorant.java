package ru.gkislin.voting.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User: gkislin
 */
@Entity
@Table(name = "restorant", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_restorant")})
public class Restorant extends NamedEntity {

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
