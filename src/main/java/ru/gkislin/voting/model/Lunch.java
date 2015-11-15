package ru.gkislin.voting.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * User: gkislin
 */
@NamedQueries({
})
@Entity
@Table(name = "lunch")//, uniqueConstraints = {@UniqueConstraint(columnNames = "date, restorant_id, name", name = "unique_lunch")})
public class Lunch extends NamedEntity {

    public Lunch() {
    }

    public Lunch(Integer id, String name) {
        super(id, name);

    }

    // price in cents
    @Column(name = "price", nullable = false)
    protected int price;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "menu_date", nullable = false)
    protected LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restorant_id", nullable = false)
    @NotNull
    private Restorant restorant;

    @Override
    public String toString() {
        return "Lunch (" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ')';
    }
}
