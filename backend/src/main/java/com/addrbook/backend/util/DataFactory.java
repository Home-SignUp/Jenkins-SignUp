package com.addrbook.backend.util;

import com.addrbook.backend.domain.Product;
import com.addrbook.backend.domain.TomcatUsers;
import com.addrbook.backend.json.ProductJson;
import com.addrbook.backend.json.UserJson;
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
    public Product createProduct(Product domain) {
        return new Product(domain);
    }

    /**
     * Converts a domain entity to a data.
     * @param status
     * @param message
     * @param domains
     * @return
     */
    public ProductJson createProduct(String status, String message, List<Product> domains) {
        ProductJson lJson = new ProductJson();
        lJson.setStatus(status);
        lJson.setMessage(message);
        lJson.setData(domains);
        return lJson;
    }

    /**
     * Converts a domain entity to a data.
     * @param domain
     * @return
     */
    public TomcatUsers createUser(TomcatUsers domain) {
        return new TomcatUsers(domain);
    }

    /**
     * Converts a domain entity to a data.
     * @param status
     * @param message
     * @param domains
     * @return
     */
    public UserJson createUser(String status, String message, List<TomcatUsers> domains) {
        UserJson lJson = new UserJson();
        lJson.setStatus(status);
        lJson.setMessage(message);
        lJson.setData(domains);
        return lJson;
    }
}
