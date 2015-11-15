package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gkislin.voting.model.Restorant;

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
}
