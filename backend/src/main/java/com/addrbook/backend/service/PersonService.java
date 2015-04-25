package com.addrbook.backend.service;

import com.addrbook.backend.domain.TomcatUsers;

import java.util.List;

/**
 * Service for managing people.
 * 
 * @author Trey
 */
public interface PersonService {
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
