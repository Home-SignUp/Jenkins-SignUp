package com.addrbook.backend.util;

import com.addrbook.backend.domain.Product;
import com.addrbook.backend.domain.TomcatUsers;
import com.addrbook.backend.json.ProductJson;
import com.addrbook.backend.json.TomcatUsersJson;
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
    public TomcatUsers createTomcatUsers(TomcatUsers domain) {
        return new TomcatUsers(domain);
    }

    /**
     * Converts a domain entity to a data.
     * @param status
     * @param message
     * @param domains
     * @return
     */
    public TomcatUsersJson createTomcatUsers(String status, String message, List<TomcatUsers> domains) {
        TomcatUsersJson lJson = new TomcatUsersJson();
        lJson.setStatus(status);
        lJson.setMessage(message);
        lJson.setData(domains);
        return lJson;
    }
}
