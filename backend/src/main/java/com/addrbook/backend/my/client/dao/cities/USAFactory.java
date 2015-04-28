package com.addrbook.backend.my.client.dao.cities;

import com.addrbook.backend.my.client.dao.interfaces.*;
import com.addrbook.backend.my.server.db.dao.Aircraft;
import com.addrbook.backend.my.server.db.dao.impl.aircraft.Boeing747;

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
