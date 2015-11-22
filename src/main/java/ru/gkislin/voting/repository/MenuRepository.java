package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import ru.gkislin.voting.model.Menu;
import ru.gkislin.voting.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

/**
 * Spring Data JPA repository for the Menu entity.
 */
@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @RestResource(path = "by-date")
    @Query("SELECT m FROM Menu m WHERE m.date=:date")
    List<Menu> findByDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @RestResource(path = "by-restaurant")
    @Query("SELECT m FROM Menu m WHERE m.restaurant=:restaurant")
    List<Menu> findByRestaurant(@Param("restaurant") Restaurant restaurant);
}
