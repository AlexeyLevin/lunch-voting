package ru.gkislin.voting.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.gkislin.voting.model.User;
import ru.gkislin.voting.repository.UserRepository;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public org.springframework.security.core.userdetails.User loadUserByUsername(final String email) {
        String lowercaseLogin = email.toLowerCase();
        log.debug("Authenticating {}", email);
        User user = userRepository.findByEmail(lowercaseLogin);
        if (user == null) {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        }
        if (!user.isEnabled()) {
            throw new DisabledException("User " + lowercaseLogin + " was not activated");
        }
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), user.getRoles());
    }
}
