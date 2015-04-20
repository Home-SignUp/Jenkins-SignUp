package com.addrbook.backend.dao;

import com.addrbook.backend.domain.Product;
import com.addrbook.backend.domain.Customer;
import com.addrbook.backend.domain.Person;

import java.util.List;

/**
 * DAO for person database table.
 * 
 * @author Trey
 */
public interface PersonDao {

	/**
	 * Selects the person record with the given id.
	 * @param id
	 * @return Returns the Person for the given id. Returns null if none found.
	 */
	Person findById(Integer id);

    List<Person> getAllPersons();

    public Customer getCustomer();

    public List<Customer> getAllCustomers();

    Product findProductById(Integer id);

    public List<Product> getAllProducts();

    public void insert(Product p);

    public void update(Product p);

    public void delete(Integer id);

	/**
	 * Inserts a person record using the non-id properties.
	 * The id property is populated with the generated id.
	 * @param person 
	 */
    public void insert(Person person);

	/**
	 * Updates the person record with p.getId().
	 * @param p
	 */
    public void update(Person p);

}