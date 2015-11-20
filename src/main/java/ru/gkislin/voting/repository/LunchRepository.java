package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.gkislin.voting.model.Lunch;
import ru.gkislin.voting.model.Menu;

import java.util.List;

/**
 * Spring Data JPA repository for the Menu entity.
 */
public interface LunchRepository extends JpaRepository<Lunch, Integer> {
    @RestResource(path = "by-date")
    @Query("SELECT l FROM Lunch l WHERE l.menu.date=:date")
    List<Lunch> findByDate(@Param("date") String date);

    @RestResource(path = "by-menu")
    @Query("SELECT l FROM Lunch l WHERE l.menu=:menu")
    List<Menu> findByMenu(@Param("menu") Menu menu);
}
