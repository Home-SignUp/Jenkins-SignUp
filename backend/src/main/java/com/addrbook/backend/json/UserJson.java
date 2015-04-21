package com.addrbook.backend.json;

import com.addrbook.backend.domain.TomcatUsers;

import java.util.List;

/**
 * Created by alexandr on 21.04.15.
 */
public class UserJson {

    private String status;
    private String  message;
    private List<TomcatUsers> data;

    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public List<TomcatUsers> getData(){
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setData(List<TomcatUsers> data){
        this.data = data;
    }

}
