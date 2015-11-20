package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gkislin.voting.model.Restorant;

/**
 * Spring Data JPA repository for the Restorant entity.
 */
public interface RestorantRepository extends JpaRepository<Restorant, Integer> {
}
