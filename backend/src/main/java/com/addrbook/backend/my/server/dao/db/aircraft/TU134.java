package com.addrbook.backend.my.server.db.dao.impl.aircraft;

import com.addrbook.backend.my.server.db.dao.Aircraft;

public class TU134 implements Aircraft {

    @Override
    public void flight() {
        System.out.println("TU-134 flight!");
    }

    
    
}
