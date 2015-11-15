package ru.gkislin.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.gkislin.voting.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    User save(User user);

    @Override
    void delete(User user);

    @Override
    User getOne(Integer id);

    @Override
    List<User> findAll();

//  Spring Data REST doesn't support Optionals
//  https://jira.spring.io/browse/DATAREST-511
    @RestResource(path = "by-email")
    @Query("SELECT u FROM User u " +
            " LEFT JOIN u.roles WHERE u.email=:email")
    User findByEmail(@Param("email") String email);
}
