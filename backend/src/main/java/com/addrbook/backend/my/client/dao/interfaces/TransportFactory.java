package com.addrbook.backend.my.client.dao.interfaces;

import com.addrbook.backend.my.server.dao.Aircraft;

// фабрика по созданию транспортных средств
public interface TransportFactory {

    // что фабрика будет производить
//    Car create();// автомобили
    Aircraft create(); // самолеты

}

/**
 * Этот пример с DAO-интерфейсом работает так:
 */