package ru.gkislin.voting.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

/**
 * GKislin
 */
@Configuration
public class AppConfig {

/*
    private static final String SPRING_HATEOAS_OBJECT_MAPPER = "_halObjectMapper";

    @Autowired
    @Qualifier(SPRING_HATEOAS_OBJECT_MAPPER)
    private ObjectMapper springHateoasObjectMapper;

    //   https://github.com/spring-projects/spring-hateoas/issues/333
    @Bean(name = "objectMapper")
    public ObjectMapper objectMapper() {
        springHateoasObjectMapper.
                setSerializationInclusion(JsonInclude.Include.NON_NULL).
                setSerializationInclusion(JsonInclude.Include.NON_EMPTY).
                setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).
                setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return springHateoasObjectMapper;
    }


    @Bean
    public ObjectMapper configeJackson(Jackson2ObjectMapperBuilder mapperBuilder) {
        return mapperBuilder.
                serializationInclusion(JsonInclude.Include.NON_NULL).
                serializationInclusion(JsonInclude.Include.NON_EMPTY).
                build().
                setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).
                setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }
*/

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Profile("dev")
    public Server h2WebServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
