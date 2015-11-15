package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import ru.gkislin.voting.model.Restorant;

import java.time.LocalDate;
import java.util.List;

/**
 * Spring Data JPA repository for the Restorant entity.
 */
public interface RestorantRepository extends JpaRepository<Restorant, Integer> {

    @Override
    Restorant save(Restorant Restorant);

    @Override
    void delete(Restorant Restorant);

    @Override
    Restorant getOne(Integer id);

    @Override
    List<Restorant> findAll();

    @RestResource(path = "for-date")
    @Query("SELECT DISTINCT(r) FROM Restorant r" +
            " LEFT JOIN r.lunches l ON (l.date=:date)")
    List<Restorant> findAllWithLunchesForDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
