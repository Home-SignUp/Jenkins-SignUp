package com.addrbook.backend.service;

import com.addrbook.backend.dao.PersonDao;
import com.addrbook.backend.domain.Product;
import com.addrbook.backend.dao.PersonDaoImpl;
import com.addrbook.backend.domain.Customer;
import com.addrbook.backend.domain.Person;
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

    public List<Person> getAllPersons(){
        return personDao.getAllPersons();
    }

    public Customer getCustomer() {
        return personDao.getCustomer();
    }

    public List<Customer> getAllCustomers() {
        return personDao.getAllCustomers();
    }

    public Product getProductById(Integer id) {
        return personDao.findProductById(id);
    }

    public List<Product> getAllProducts() {
        return personDao.getAllProducts();
    }

	@Transactional
	public void savePerson(Person person) {
		personDao.insert(person);
	}

	public void updatePerson(Person p) {
		personDao.update(p);
	}

    public void updateProduct(Product p) {
        personDao.update(p);
    }
}
