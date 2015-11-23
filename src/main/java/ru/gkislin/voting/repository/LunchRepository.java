package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import ru.gkislin.voting.model.Lunch;
import ru.gkislin.voting.model.Menu;

import java.time.LocalDate;
import java.util.List;

/**
 * Spring Data JPA repository for the Menu entity.
 */
public interface LunchRepository extends JpaRepository<Lunch, Integer> {
    @RestResource(path = "by-date")
    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l WHERE l.menu.date=:date")
    List<Lunch> findByDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @RestResource(path = "by-menu")
    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l WHERE l.menu=:menu")
    List<Menu> findByMenu(@Param("menu") Menu menu);

    @Override
    @Secured("ROLE_ADMIN")
    Lunch save(Lunch entity);

    @Override
    @Secured("ROLE_ADMIN")
    void delete(Integer id);
}
