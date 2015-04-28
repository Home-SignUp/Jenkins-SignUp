package com.addrbook.backend.my.server.dao.db.car;

import com.addrbook.backend.my.server.dao.Car;

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
