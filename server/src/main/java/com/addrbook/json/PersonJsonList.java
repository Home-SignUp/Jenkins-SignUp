package com.addrbook.json;

import java.util.List;

/**
 * Created by Саша on 18.03.2015.
 */
public class PersonJsonList {

    private List<PersonJson> persons;

    public List<PersonJson> getPersonJson(){
        return persons;
    }
    public void setPersonJson(List<PersonJson> persons){
        this.persons = persons;
    }

}
