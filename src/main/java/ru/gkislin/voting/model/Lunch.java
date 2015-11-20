package ru.gkislin.voting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: gkislin
 */
@Entity
@Table(name = "lunch", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "name"}, name = "unique_lunch")})
public class Lunch extends NamedEntity {

    @Column(name = "price", nullable = false)
    private int price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    private Menu menu;

    public Lunch() {
    }

    public Lunch(Integer id, String name, int priceInCents) {
        super(id, name);
        this.price = priceInCents;
    }

    @Override
    public String toString() {
        return "Lunch (" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ')';
    }
}
