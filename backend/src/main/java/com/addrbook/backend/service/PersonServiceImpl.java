package com.addrbook.backend.service;

import com.addrbook.backend.dao.PersonDao;
import com.addrbook.backend.dao.PersonDaoImpl;
import com.addrbook.backend.domain.Product;
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

    public Product getProductById(Integer id) {
        return personDao.findProductById(id);
    }

    public List<Product> getAllProducts() {
        return personDao.getAllProducts();
    }

    public void updateProduct(Product p) {
        personDao.update(p);
    }

    @Transactional
    public void saveProduct(Product p) {
        personDao.insert(p);
    }

    public void deleteProduct(Integer id) {
        personDao.delete(id);
    }
}
