package ru.gkislin.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: gkislin
 */
@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_date", "restaurant_id"}, name = "unique_menu")})
public class Menu extends BaseEntity {

    @NotNull
    @Column(name = "menu_date", nullable = false)
    //TODO switch to LocalDate
    private String date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Menu() {
    }

    public Menu(Integer id, Restaurant restaurant, String date) {
        super(id);
        this.restaurant = restaurant;
        this.date = date;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Menu (" +
                "id=" + getId() +
                ", date=" + date +
                ')';
    }
}
