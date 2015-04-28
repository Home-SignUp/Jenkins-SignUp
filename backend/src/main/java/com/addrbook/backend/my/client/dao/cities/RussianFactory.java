package com.addrbook.backend.my.client.dao.cities;

import com.addrbook.backend.my.client.dao.interfaces.*;
import com.addrbook.backend.my.server.db.dao.Aircraft;
import com.addrbook.backend.my.server.db.dao.impl.aircraft.TU134;

// российские транспортные средства
public class RussianFactory implements TransportFactory {
//    @Override
//    public Car create() {
//        return new Niva();
//    }

    @Override
    public Aircraft create() {
        return new TU134();
    }
}
