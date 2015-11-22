package ru.gkislin.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableEntityLinks;

@SpringBootApplication
@EnableJpaRepositories("ru.gkislin.voting.repository")
// Explicitly enable entity links as Boot fails to auto-configure them
@EnableEntityLinks
// Explicitly configure @EntityScan to enable the JSR-310 JPA 2.1 converters
@EntityScan(basePackages = "ru.gkislin.voting.model", basePackageClasses = {Jsr310JpaConverters.class})
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
