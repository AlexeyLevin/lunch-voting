Voting system for deciding where to have lunch (REST only).
==================

### <a href="https://gist.github.com/juozapas/f20b55e4568d7f5c63b1">Тестовое задание</a>

## Install:

    git clone https://github.com/gkislin/lunch-voting

- DEV Properties (`/src/main/resources/application-dev.properties`)
  - <a href="http://localhost:8082/">H2 console</a> (JDBC URL: `jdbc:h2:mem:voting`, User: `sa`)
  - Remote connection: URL: `tcp://localhost:9092/mem:voting`, User: `sa`

- Defult Properties: (`/src/main/resources/application.properties`)
  - JDBC URL: `jdbc:h2:file:~/voting`, User: `sa`, Password: `password`
  - Remote connection: URL: `jdbc:h2:tcp://localhost:9092/~/voting`, User: `sa`, Password: `password`

## Run

## Test
  - <a href="http://localhost:8080/apiV1">Rest API base</a>

### User handling


    curl "http://localhost:8080/apiV1/users" -H "Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ="
    curl "http://localhost:8080/apiV1/users/0" -H "Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ="
    curl "http://localhost:8080/apiV1/users" -d "{\"name\" : \"NewUser\", \"email\" : \"new@mail.ru\",\"roles\" : [\"ROLE_USER\"]}" -H "Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=" -H "Content-Type: application/json"
    curl "http://localhost:8080/apiV1/users/search/by-email?email=admin@gmail.com" -H "Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ="



-----------
## H2
-  <a href="http://stackoverflow.com/questions/24803279/grails-accessing-h2-tcp-server-hangs#33718748">H2 TCP connection</a>

## Spring Boot
-  <a href="http://blog.jetbrains.com/idea/2015/04/webinar-recording-spring-boot-and-intellij-idea-14-1">Spring Boot and Intellij IDEA 14</a>
-  https://github.com/snicoll-demos/spring-boot-intellij-idea-webinar
-  <a href="http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/">Spring Boot Reference Guide</a>
-  <a href="https://github.com/spring-projects/spring-boot">spring-projects/spring-boot</a>
-  <a href="http://spring.io/guides/tutorials/bookmarks/">Building REST services with Spring</a>
-  <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html">Common application properties</a>"
-  <a href="http://stackoverflow.com/questions/25855795/spring-boot-and-multiple-external-configuration-files">Multiple external configuration</a>"

## REST
http://curl.haxx.se/docs/manpage.html
http://spring.io/guides/gs/accessing-data-rest/
https://github.com/spring-guides/gs-accessing-data-rest

org\springframework\web\servlet\DispatcherServlet.java
   mappedHandler = getHandler(processedRequest)

org.springframework.data.rest.core.mapping.ResourceMetadata
		for (ResourceMetadata metadata : cache.values()) {