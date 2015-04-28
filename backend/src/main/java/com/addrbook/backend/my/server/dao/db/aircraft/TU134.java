package com.addrbook.backend.my.server.dao.db.aircraft;

import com.addrbook.backend.my.server.dao.Aircraft;

public class TU134 implements Aircraft {

    @Override
    public void flight() {
        System.out.println("TU-134 flight!");
    }

    
    
}
