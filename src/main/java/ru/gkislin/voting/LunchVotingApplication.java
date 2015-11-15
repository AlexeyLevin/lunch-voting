package ru.gkislin.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ru.gkislin.voting.repository")
public class LunchVotingApplication {


    /*
        @Bean
        @Profile("dev")
        public ServletRegistrationBean h2Console() {
            ServletRegistrationBean reg = new ServletRegistrationBean(new WebServlet(), "/console*/
/*");
        reg.setLoadOnStartup(1);
        return reg;
    }

*/
    public static void main(String[] args) {
        SpringApplication.run(LunchVotingApplication.class, args);
    }
}
