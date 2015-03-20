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


###@requestmapping passing parameters

* http://www.codejava.net/frameworks/spring/14-tips-for-writing-spring-mvc-controller
http://www.mkyong.com/spring-mvc/spring-3-rest-hello-world-example/
http://gotoanswer.stanford.edu/?q=Passing+multiple+parameters+from+view+to+controller+in+spring+mvc
http://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
http://www.javabeat.net/multiple-parameters-spring-mvc-controller/
* http://www.captaindebug.com/2011/07/accessing-request-parameters-using.html#.VQiLNOFGRmE
http://www.journaldev.com/3358/spring-mvc-requestmapping-annotation-example-with-controller-methods-headers-params-requestparam-pathvariable


###Разворачиваем локальный сервер на Windows

- http://habrahabr.ru/post/150972/


###генератор схем баз данных & базы данных повер дизайнер

- http://lib.kstu.kz:8300/tb/books/Proektirovanie_baz_dann@ih/teory/10_1.htm


###Git Merge branch

* > git branch
*   master
*   release
* > git checkout master
*   Switched to branch 'master'
*   Your branch is up-to-date with 'origin/master'.
* > git merge release
*
* > git branch
* * master
*   release
* > git push origin master
* Username for 'https://github.com': sashakmets
* Password for 'https://sashakmets@github.com':
* Total 0 (delta 0), reused 0 (delta 0)
* To https://github.com/Home-Spring/AddressBook-2
*   b489247..0f1ef2d  master -> master