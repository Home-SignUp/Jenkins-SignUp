package com.addrbook.util;

import com.addrbook.data.PersonData;
import com.addrbook.data.PersonDataList;
import com.addrbook.domain.Person;
import org.springframework.stereotype.Component;

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
	public PersonData createPerson(Person domain) {
		PersonData data = new PersonData();
        data.setId(domain.getId());
        data.setFullname(domain.getFirstName() + " " + domain.getLastName());
		return data;
	}

    public PersonDataList createPerson(List<PersonData> domain) {
        PersonDataList data = new PersonDataList();
        data.setPersonData(domain);
        return data;
    }
}
