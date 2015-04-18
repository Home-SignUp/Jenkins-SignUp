package com.addrbook.backend.json;

import com.addrbook.backend.domain.Product;

import java.util.List;

/**
 * Created by alexandr on 08.04.15.
 */
public class ProductJson {

    private String status;
    private String  message;
    private List<Product> data;

    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public List<Product> getData(){
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setData(List<Product> data){
        this.data = data;
    }

}
