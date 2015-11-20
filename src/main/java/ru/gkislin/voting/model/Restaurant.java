package ru.gkislin.voting.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User: gkislin
 */
@Entity
@Table(name = "restaurant", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_restaurant")})
public class Restaurant extends NamedEntity {

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Restaurant (" +
                "id=" + getId() +
                ", name=" + name +
                ')';
    }
}
