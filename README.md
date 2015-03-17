Address Book (2)
========

###Technology stack

1. Spring 3.2. REST service with JSON payload. Uses spring-test for integration tests.
1. AngularJS 1.2. Minimalist, focused on demonstration of consuming REST service.
1. Embedded HSQL database.

Additionally, this project contains no XML. Spring config is fully annotation driven and the web.xml is omitted per Servlet 3.0 spec.

###Resources

* http://www.rockhoppertech.com/blog/spring-mvc-configuration-without-xml/
* http://www.java-allandsundry.com/2012/11/spring-test-mvc-with-spring-32rc1.html
* http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/
* http://www.javacodegeeks.com/2012/10/junit-testing-spring-service-and-dao.html


###URL

*  (Spring + REST + Angular: Creating the API — Part 1 of 2) http://www.pinnsg.com/spring-rest-angular-creating-api/
* (Spring + REST + Angular: Consuming the API — Part 2 of 2) http://www.pinnsg.com/spring-rest-angular-consuming-api/
*                                                      (GIT) https://github.com/thoward333/addrbook
*                                                            https://github.com/thoward333


###Work

1.  [GET] http://localhost:8080/AddressBook-2/#/home
2. [POST] http://localhost:8080/AddressBook%2D2/api/person
          "{"userName":"admin-2","firstName":"adminfirst-2","lastName":"adminlast-2"}"