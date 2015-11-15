package ru.gkislin.voting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: gkislin
 */
@Entity
@Table(name = "vote", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "menu_id"}, name = "unique_vote")})
public class Vote extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    private Menu menu;

    public Vote() {
    }

    public Vote(Integer id, User user, Menu menu) {
        super(id);
        this.user = user;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Vote (id=" + getId() + ')';
    }
}
