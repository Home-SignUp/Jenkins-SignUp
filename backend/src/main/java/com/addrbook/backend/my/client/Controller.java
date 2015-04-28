package com.addrbook.backend.my.client;

import com.addrbook.backend.my.client.api.Cities;
import com.addrbook.backend.my.client.api.CityService;
import com.addrbook.backend.my.client.dao.interfaces.*;

public class Controller {
    public static CityService citySelector = new CityService();
    public static TransportFactory factory;
    
    public static void main(String[] args) {
        factory = citySelector.getFactory(Cities.RUSSIAN);
//        factory = citySelector.getFactory(Cities.USA);

//        factory.create().drive();
//        factory.create().stop();
        factory.create().flight();
    }
}

/**
 * "DAO-слой" - это есть абстрактный слой который отвязывает прямые зависимости между сущностями и реализацией.
 *
 * Например: у меня есть какая-то таблица определенного типа. Для работы с такой структурой таблицы в коде я могу создать конкретный тип класса.
 * Мой тип класса (объект) может быть использован и с помощью Hibernate а также и как-то еще...
 * Все эти манипуляции (обработка) лежит на стороне сервера.
 *
 * Реализация моего типа класса будет лежать на стороне клиента, в "Сервисах".
 * Какое-то API будет реализовывать мои сервисные функции для выполнения каких-либо операций и поэтому внутри их тип будет неизменный.
 *
 * Все изменения по типам классов должны выполняться (только) внутри DAO-слоя.
 * Все время я буду работать с каким-то интерфейсом, только в DAO-слое я определяю конкретный тип данных для моего класса.
 *
 * И на выходе (у меня это будет контроллер) тип объекта остается неизменным, могут меняться только его специфические поля.
 *
 *
 * Конкретную реализацию для каждого типа можно использовать в случаях например при работе с разными типами базами данных (для которых
 * могут применятся разные технологии).
 */