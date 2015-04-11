Example Spring Boot REST Service
================================

The article: [http://kielczewski.eu/2014/04/developing-restful-web-service-with-spring-boot/](http://kielczewski.eu/2014/04/developing-restful-web-service-with-spring-boot/)

Requirements
------------
* [Java Platform (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)

Quick start
-----------
1. `mvn package`
2. `java -jar target/example-spring-boot-rest-1.0-SNAPSHOT.jar`
3. Point your browser to [http://localhost:8080](http://localhost:8080)
4. `curl -X POST -d '{ "id": "test_id", "password": "test_password" }' http://localhost:8080/user`
5. Refresh the page

Проверил:
---------
1. `ссылка на статью` [http://kielczewski.eu/2014/04/developing-restful-web-service-with-spring-boot/](http://kielczewski.eu/2014/04/developing-restful-web-service-with-spring-boot/) ([rus](https://translate.google.com.ua/translate?sl=en&tl=ru&js=y&prev=_t&hl=ru&ie=UTF-8&u=http%3A%2F%2Fkielczewski.eu%2F2014%2F04%2Fdeveloping-restful-web-service-with-spring-boot%2F&edit-text=))
2. `maven-3 jdk-7`
3. `mvn clean package`
4. `в terminal(е)` java -jar target/frontend-1.0-SNAPSHOT.jar
5. `POST` [http://localhost:8082/user](http://localhost:8082/user) {"id":"test_id","password":"test_password"}
6. `GET` [http://localhost:8082/user](http://localhost:8082/user)