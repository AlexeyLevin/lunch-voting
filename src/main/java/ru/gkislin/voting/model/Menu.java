package ru.gkislin.voting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

/**
 * User: gkislin
 */
@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_date", "restorant_id"}, name = "unique_menu")})
public class Menu extends BaseEntity {

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "menu_date", nullable = false)
    private LocalDate date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restorant_id", nullable = false)
    @NotNull
    private Restorant restorant;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "menu")
    private Set<Lunch> lunches;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    private Set<Vote> votes;

    public Menu() {
    }

    public Menu(Integer id, Restorant restorant, LocalDate date) {
        super(id);
        this.restorant = restorant;
        this.date = date;
    }


    @Override
    public String toString() {
        return "Menu (" +
                "id=" + getId() +
                ", date=" + date +
                ')';
    }
}
