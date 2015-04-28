package com.addrbook.backend.my.server.db.dao.impl.car;

import com.addrbook.backend.my.server.db.dao.Car;

public class Niva implements Car {

    @Override
    public void drive() {
        System.out.println("Niva drive");
    }

    @Override
    public void stop() {
        System.out.println("Niva stopped");
    }
    
}
