package com.addrbook.service;

import com.addrbook.dao.PersonDao;
import com.addrbook.dao.PersonDaoImpl;
import com.addrbook.data.PersonData;
import com.addrbook.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;
    private PersonDaoImpl personDaoImpl;

	@Autowired
	public PersonServiceImpl(PersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	public Person getPersonById(Integer id) {
		return personDao.findById(id);
	}

    public List<PersonData> getPersonsList(){
        return personDaoImpl.getPersons();
    }

	@Transactional
	public void savePerson(Person person) {
		personDao.insert(person);
	}

//	public void updatePerson(Person p) {
//		personDao.update(p);
//	}

}
