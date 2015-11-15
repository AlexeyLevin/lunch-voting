package ru.gkislin.voting.model;

import javax.persistence.*;
import java.util.Set;

/**
 * User: gkislin
 */
@NamedQueries({
})
@Entity
@Table(name = "restorant", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_restorant")})
public class Restorant extends NamedEntity {

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "restorant")
    protected Set<Lunch> lunches;

    public Restorant() {
    }

    public Restorant(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Restorant (" +
                "id=" + id +
                ", name=" + name +
                ')';
    }
}
