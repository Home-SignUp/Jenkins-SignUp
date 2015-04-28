package com.addrbook.backend.my.server.dao.db.aircraft;

import com.addrbook.backend.my.server.dao.Aircraft;

public class Boeing747 implements Aircraft{

    @Override
    public void flight() {
        System.out.println("Boeing-747 flight!");
    }
    
}
