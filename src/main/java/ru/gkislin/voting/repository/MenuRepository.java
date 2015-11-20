package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.gkislin.voting.model.Menu;
import ru.gkislin.voting.model.User;

import java.time.LocalDate;

/**
 * Spring Data JPA repository for the Menu entity.
 */
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @RestResource(path = "by-date")
    @Query("SELECT m FROM Menu m WHERE m.date=:date")
    User findByDate(@Param("date") LocalDate date);
}
