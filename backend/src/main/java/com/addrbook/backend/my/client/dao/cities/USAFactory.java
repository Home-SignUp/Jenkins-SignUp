package com.addrbook.backend.my.client.dao.cities;

import com.addrbook.backend.my.client.dao.interfaces.TransportFactory;
import com.addrbook.backend.my.server.dao.Aircraft;
import com.addrbook.backend.my.server.dao.db.aircraft.Boeing747;

// американские транспортные средства
public class USAFactory implements TransportFactory {
//    @Override
//    public Car create() {
//        return new Porsche();
//    }

    @Override
    public Aircraft create() {
        return new Boeing747();
    }
}
