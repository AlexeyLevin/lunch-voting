package ru.gkislin.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.gkislin.voting.model.converter.LocalDateConverter;

@SpringBootApplication
@EnableJpaRepositories("ru.gkislin.voting.repository")

/**
 * Explicitly configure @EntityScan to enable the JSR-310 JPA 2.1 converters
 * @EntityScan(basePackages = "ru.gkislin.voting.model", basePackageClasses = {Jsr310JpaConverters.class})
 * Commented as LocalDate mapped to Timestamp. Map via {@link LocalDateConverter}
 */
public class LunchVotingApplication {


    /*
        @Bean
        @Profile("dev")
        public ServletRegistrationBean h2Console() {
            ServletRegistrationBean reg = new ServletRegistrationBean(new WebServlet(), "/console**");
        reg.setLoadOnStartup(1);
        return reg;
        }
    */
    public static void main(String[] args) {
        SpringApplication.run(LunchVotingApplication.class, args);
    }
}
