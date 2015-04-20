package com.addrbook.backend.service;

import com.addrbook.backend.domain.Product;

import java.util.List;

/**
 * Service for managing people.
 * 
 * @author Trey
 */
public interface PersonService {

	/**
	 * @param id
	 * @return Returns the product with the given id.
	 */
    public Product getProductById(Integer id);

    public List<Product> getAllProducts();

	/**
	 * Creates a new Person and populates the <code>id</code> property with the generated id.
	 * @param p All non-id properties are used to create the new person.
	 */
    public void saveProduct(Product p);
	
	/**
	 * @param p The person to be updated.
	 */
    public void updateProduct(Product p);

    public void deleteProduct(Integer id);

}
