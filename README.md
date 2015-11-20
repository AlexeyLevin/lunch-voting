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
$ SPRING_PROFILES_ACTIVE=production
$ mvn spring-boot:run

$ mvn spring-boot:run -Dspring.profiles.active=production

## Build JAR:
$ mvn clean package
$ java -jar target/spring-and-angular-0.0.1-SNAPSHOT.jar


## Test
  - <a href="http://localhost:8080/api">The HAL Browser</a>

    User login: user@yandex.ru
      password: password
      "Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ="


    Admin login: admin@gmail.com
       password: admin
       "Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu"

### User handling

    403:Forbidden
    curl 'http://localhost:8080/api/users' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='

    curl 'http://localhost:8080/api/users' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl 'http://localhost:8080/api/users/0' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl 'http://localhost:8080/api/users' -i -d'{"name\' : "NewUser", "email\' : "new@mail.ru","password\' : "123456","roles\' : ["ROLE_USER"]}' -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
    curl 'http://localhost:8080/api/users/search/by-email?email=admin@gmail.com' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'

### Restorant handling

    curl 'http://localhost:8080/api/restorants' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
    curl 'http://localhost:8080/api/restorants/0' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
    curl 'http://localhost:8080/api/restorants' -i -d'{"name\' : "Subway"}' -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'
    curl 'http://localhost:8080/api/restorants/search/by-email?email=admin@gmail.com' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='

### Menu handling

    curl 'http://localhost:8080/api/menus' -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
    curl 'http://localhost:8080/api/menus/0' -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
    curl 'http://localhost:8080/api/menus' -d'{"date" : "2015-11-17", "restorant":"http://localhost:8080/api/restorants/0"}' -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'
    curl 'http://localhost:8080/api/menus/1' -X PUT -d'{"date" : "2015-11-16"}' -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'

### Lunch handling

-----------
## H2
-  <a href="http://stackoverflow.com/questions/24803279/grails-accessing-h2-tcp-server-hangs#33718748">H2 TCP connection</a>

## Spring Boot
-  <a href="http://blog.jetbrains.com/idea/2015/04/webinar-recording-spring-boot-and-intellij-idea-14-1">Spring Boot and Intellij IDEA 14</a>
-  https://github.com/snicoll-demos/spring-boot-intellij-idea-webinar
-  <a href="http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/">Spring Boot Reference Guide</a>
-  <a href="https://github.com/spring-projects/spring-boot">spring-projects/spring-boot</a>
-  <a href="http://spring.io/guides/tutorials/bookmarks/">Building REST services with Spring</a>
-  <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html">Common application properties</a>
-  <a href="http://stackoverflow.com/questions/25855795/spring-boot-and-multiple-external-configuration-files">Multiple external configuration</a>

## REST
- http://curl.haxx.se/docs/manpage.html
- http://spring.io/guides/gs/accessing-data-rest/
- https://github.com/spring-guides/gs-accessing-data-rest

org\springframework\web\servlet\DispatcherServlet.java
   mappedHandler = getHandler(processedRequest)

org.springframework.data.rest.core.mapping.ResourceMetadata
		for (ResourceMetadata metadata : cache.values()) {
- <a href="https://spring.io/blog/2014/07/14/spring-data-rest-now-comes-with-alps-metadata">Spring Data REST now comes with ALPS metadata</a>
- HAL: https://tools.ietf.org/html/draft-kelly-json-hal-07

## ETag
- https://objectpartners.com/2015/06/02/etags-and-spring-data-rest/
- http://stackoverflow.com/questions/31882180/why-is-the-version-property-not-set-with-spring-data-jpa


## ID
- https://github.com/spring-projects/spring-hateoas/issues/66
- https://github.com/spring-projects/spring-hateoas/issues/67
- https://github.com/gregturn/task-manager-app
- http://stackoverflow.com/questions/24936636/while-using-spring-data-rest-after-migrating-an-app-to-spring-boot-i-have-obser
- http://stackoverflow.com/questions/24839760/spring-boot-responsebody-doesnt-serialize-entity-id

## JSON
https://github.com/spring-projects/spring-hateoas/issues/333
