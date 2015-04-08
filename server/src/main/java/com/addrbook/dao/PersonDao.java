package com.addrbook.dao;

import com.addrbook.domain.Customer;
import com.addrbook.domain.Person;
import com.addrbook.domain.Product;

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

    public List<Product> getAllProducts();

	/**
	 * Inserts a person record using the non-id properties.
	 * The id property is populated with the generated id.
	 * @param person 
	 */
	void insert(Person person);

	/**
	 * Updates the person record with p.getId().
	 * @param p
	 */
	void update(Person p);

}