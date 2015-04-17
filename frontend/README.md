Jenkins SignUp (Server)
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


###REST

* http://10.13.70.25/my_test/angular/Jenkins-SignUp-Client/src/web/ajax/getCustomers.php
* http://localhost:8080/api/customers
* http://localhost:8080/api/customer
* http://localhost:8080/api/persons
* http://localhost:8080/api/person/1


###java web patterns & mediator pattern

> Design Patterns web based applications
>> http://stackoverflow.com/questions/3541077/design-patterns-web-based-applications
>
> Web MVC framework
>> http://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/mvc.html
>
> Посередник (шаблон проектування)
>> http://uk.m.wikipedia.org/wiki/Посередник_(шаблон_проектування)
>>
>> http://www.uml.org.cn/c++/pdf/DesignPatterns.pdf


###Description

> Разработка Web-приложения (в частности и на Java) это прежде всего коммандная работа. Ее структуру можно представить из звеньевых цеопчек.
> На самой вершине стоит заказчик (customer) который заказывает продукт.
> С этим заказчиком общается бизнес-аналитик (посредник) и выясняет какой конкретно продукт ему нужен.
> Дальше Web-приложение разбивается на две части: клиентскую (над которой работают дизайнеры, разработчики) и серверную (над которой работают архитектор, разработчики).
> Web-приложение имеет клиентскую часть и серверную часть.
>
> Все те запросы которые исходят из адрессной строки веб-браузера строго должны попадать только в клиентскую часть (и никак непересекаться с серверной частью).
> Клиентская часть генерит и возвращает web-страницы.
> А вот уже формы, которые находятся внутри этих web-страниц, ссылаются уже на серверную часть.
> Точкой входа серверной части Web-приложения является - 'контроллер'.
>> Устройство 'Controller' - оговаривается между заказчиком, бизнес-аналитиком и архитектором. С одной стороны на входе контроллера имеются аддресса-URL-ссылок которые будет прослушивать сервер.
> С другой стороны на выходе контроллера имеются API-функции которые будут выполнять какие-то дествия и возвращать запрашиваемую информацию...
>>
>> Контроллер обменивается данными с клиентской частью через JSON-формат.
>
> Архитектор строит интерфейсы для API-функций.
> Именно эти (интерфейсные) API-функций изначально и прописываются в контроллере, в самом начале, при построении Web-приложения.
> А дальше, между интерфейсными API-функциями и контролером, разработчики имплементят (интерфейсные) API-функций и пишут для них реализацию.
>
>> Реализация (интерфейсных) API-функций тоже имеют имеют свои версии, но эти версии уже относятся имено к уровню внутренней реализации фукнций (если нужно поправить какие-либо ошибки или добавить изменения)...
>
> Реализация (интерфейсных) API-функций входит в состав блока 'сервисного слоя' (а потом уже попадает в контроллер).
>
> И на этом уровне тоже применяются шаболоны-проектирования для повышения качества и надежности...


###NamedParameterJdbcTemplate & hsql команды
> http://www.dineshonjava.com/2012/12/using-namedparameterjdbctemplate-in.html#.VQ-2_Z_7t0x
>
> http://donklass.net/eclipse/94-servlet-jsp-jpa.html
>
> http://rtfm.co.ua/teamcity-migraciya-bazy-dannyx-s-hsqldb-na-mysql/
>
> http://www.spring-source.ru/articles.php?type=manual&theme=articles&docs=article_01
>
> http://anteastra.blogspot.com/2013/04/hsqldb.html
>
> http://habrahabr.ru/sandbox/23199/
>
> http://hsqldb.org/


