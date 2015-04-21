package com.addrbook.backend.service;

import com.addrbook.backend.domain.Product;
import com.addrbook.backend.domain.TomcatUsers;

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


    /**
     * @param userName
     * @return Returns the user with the given userName.
     */
    public TomcatUsers getUserById(String userName);

    public List<TomcatUsers> getAllUsers();

    /**
     * Creates a new User and populates the <code>userName</code> property with the generated userName.
     * @param u All non-id properties are used to create the new user.
     */
    public void saveUser(TomcatUsers u);

    /**
     * @param u The user to be updated.
     */
    public void updateUser(TomcatUsers u);

    public void deleteUser(String userName);

}
