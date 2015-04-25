package com.addrbook.backend.service;

import com.addrbook.backend.dao.PersonDao;
import com.addrbook.backend.dao.PersonDaoImpl;
import com.addrbook.backend.domain.TomcatUsers;
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


    public TomcatUsers getUserById(String userName) {
        return personDao.findUserById(userName);
    }

    public List<TomcatUsers> getAllUsers() {
        return personDao.getAllUsers();
    }

    public void updateUser(TomcatUsers u) {
        personDao.update(u);
    }

    @Transactional
    public void saveUser(TomcatUsers u) {
        personDao.insert(u);
    }

    public void deleteUser(String userName) {
        personDao.delete(userName);
    }
}
