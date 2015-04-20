package com.addrbook.backend.util;

import com.addrbook.backend.domain.Product;
import com.addrbook.backend.json.ProductJson;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Factory methods for creating DTOs.
 * 
 * @author Trey
 */
@Component
public class DataFactory {

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
}
