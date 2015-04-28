package com.addrbook.backend.my.server.dao.db.car;

import com.addrbook.backend.my.server.dao.Car;

public class Porsche implements Car {

    @Override
    public void drive() {
        System.out.println("Drive speed 150 km/h");
    }

    @Override
    public void stop() {
        System.out.println("Stopped at 1 sec");
    }

}
