package ru.gkislin.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: gkislin
 */
@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_date", "restorant_id"}, name = "unique_menu")})
public class Menu extends BaseEntity {

    @NotNull
    @Column(name = "menu_date", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "restorant_id", nullable = false)
    @NotNull
    private Restorant restorant;

    public Menu() {
    }

    public Menu(Integer id, Restorant restorant, Date date) {
        super(id);
        this.restorant = restorant;
        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Restorant getRestorant() {
        return restorant;
    }

    public void setRestorant(Restorant restorant) {
        this.restorant = restorant;
    }

    @Override
    public String toString() {
        return "Menu (" +
                "id=" + getId() +
                ", date=" + date +
                ')';
    }
}
