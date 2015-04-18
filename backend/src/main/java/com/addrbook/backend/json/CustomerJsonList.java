package com.addrbook.backend.json;

import com.addrbook.backend.domain.Customer;

import java.util.List;

/**
 * Created by alexandr on 20.03.15.
 */
public class CustomerJsonList {

    private List<Customer> customer;

    public List<Customer> getCustomerJson(){
        return customer;
    }
    public void setCustomerJson(List<Customer> customer){
        this.customer = customer;
    }

}
