package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.gkislin.voting.model.Restaurant;

import java.util.List;

/**
 * Spring Data JPA repository for the Restaurant entity.
 */
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @RestResource(path = "by-name")
    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE CONCAT('%',:name,'%')")
    List<Restaurant> findByName(@Param("name") String name);
}
