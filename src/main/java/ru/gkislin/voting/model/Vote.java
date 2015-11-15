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
@Table(name = "vote")//, uniqueConstraints = {@UniqueConstraint(columnNames = "date, user_id", name = "unique_vote")})
public class Vote extends BaseEntity {

    public Vote() {
    }

    public Vote(Integer id, User user, Restorant restorant) {
        super(id);
        this.user = user;
        this.restorant = restorant;
    }

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "vote_date", nullable = false)
    protected LocalDate date;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "vote_time", nullable = false)
    protected LocalDate time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restorant_id", nullable = false)
    @NotNull
    private Restorant restorant;

    @Override
    public String toString() {
        return "Vote (" +
                "id=" + id +
                ", date=" + date +
                ')';
    }
}
