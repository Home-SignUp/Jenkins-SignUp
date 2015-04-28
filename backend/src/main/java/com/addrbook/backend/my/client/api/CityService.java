package com.addrbook.backend.my.client.api;

import com.addrbook.backend.my.client.dao.cities.*;
import com.addrbook.backend.my.client.dao.interfaces.*;

// фабрика по созданию автомобилей
public class CityService {
    
    // фабричный метод, который создает нужный автомобиль
    public TransportFactory getFactory(Cities transportCity){
        TransportFactory factory = null;
        switch (transportCity){
            case RUSSIAN:
                factory = new RussianFactory();
                break;
            case USA:
                factory = new USAFactory();
                break;
        }

        return factory;
    }
}
