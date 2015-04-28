package com.addrbook.backend.my.server.db.dao.impl.aircraft;

import com.addrbook.backend.my.server.db.dao.*;

public class Boeing747 implements Aircraft{

    @Override
    public void flight() {
        System.out.println("Boeing-747 flight!");
    }
    
}
