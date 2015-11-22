package ru.gkislin.voting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gkislin.voting.LoggedUser;
import ru.gkislin.voting.model.Menu;
import ru.gkislin.voting.model.Vote;
import ru.gkislin.voting.service.VoteService;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * GKislin
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    private final Logger log = LoggerFactory.getLogger(VoteService.class);

    private static final LocalTime EXPIRED_TIME = LocalTime.parse("11:00");

    @Autowired
    private VoteService voteService;

    @Autowired
    private EntityLinks entityLinks;

    /**
     * Accepts a user vote for an {@link Menu}
     *
     * @param menu the {@link Menu} user vote for.
     *             Retrieved from the path variable and converted into an {@link Menu} instance by Spring Data's {@link DomainClassConverter}.
     * @return {@link Menu} user voted and code 200 Updated, 201 Created or 409 Conflict
     */

    @RequestMapping(value = "/vote/{id}", method = POST)
    ResponseEntity<Resource<Vote>> vote(@PathVariable("id") Menu menu) {
        LocalDate today = LocalDate.now();
        if (menu == null || !menu.getDate().equals(today)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        int userId = LoggedUser.id();
        boolean expired = LocalTime.now().isAfter(EXPIRED_TIME);
        VoteService.VoteWithStatus voteWithStatus = expired ?
                voteService.saveIfAbsent(userId, menu) :
                voteService.save(userId, menu);
        Resource<Vote> resource = new Resource<>(voteWithStatus.getVote());
        return new ResponseEntity<>(resource,
                voteWithStatus.isCreated() ? HttpStatus.CREATED : (expired ? HttpStatus.CONFLICT : HttpStatus.OK));
    }
}
