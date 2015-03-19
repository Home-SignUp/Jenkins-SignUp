package com.addrbook.util;

import com.addrbook.json.PersonJson;
import com.addrbook.json.PersonJsonList;
import com.addrbook.domain.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Factory methods for creating DTOs.
 * 
 * @author Trey
 */
@Component
public class DataFactory {

	/**
	 * Converts a domain entity to a data.
	 * @param domain
	 * @return
	 */
	public PersonJson createPerson(Person domain) {
		PersonJson json = new PersonJson();
        json.setId(domain.getId());
        json.setFullname(domain.getFirstName() + " " + domain.getLastName());
		return json;
	}

    public PersonJsonList createPerson(List<Person> domains) {
        PersonJson        json = new PersonJson();
        List<PersonJson> jsons = new ArrayList<PersonJson>();
        Iterator      iDomains = domains.iterator();

        while( iDomains.hasNext() ){
            Person domain = (Person)iDomains.next();
            json.setId(domain.getId());
            json.setFullname(domain.getFirstName() + " " + domain.getLastName());
            jsons.add(json);
        }

        PersonJsonList lJson = new PersonJsonList();
        lJson.setPersonJson(jsons);
        return lJson;
    }
}
