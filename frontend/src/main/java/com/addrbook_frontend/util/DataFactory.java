//package com.addrbook.util;
//
//import com.addrbook_frontend.domain.Customer;
//import com.addrbook_frontend.domain.Person;
//import com.addrbook_frontend.domain.Product;
//import com.addrbook_frontend.json.CustomerJsonList;
//import com.addrbook_frontend.json.PersonJson;
//import com.addrbook_frontend.json.PersonJsonList;
//import com.addrbook_frontend.json.ProductJson;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * Factory methods for creating DTOs.
// *
// * @author Trey
// */
//@Component
//public class DataFactory {
//
//	/**
//	 * Converts a domain entity to a data.
//	 * @param domain
//	 * @return
//	 */
//	public PersonJson createPerson(Person domain) {
//		PersonJson json = new PersonJson();
//        json.setId(domain.getId());
//        json.setFullname(domain.getFirstName() + " " + domain.getLastName());
//		return json;
//	}
//
//    public PersonJsonList createPerson(List<Person> domains) {
//        PersonJson        json = new PersonJson();
//        List<PersonJson> jsons = new ArrayList<PersonJson>();
//        Iterator      iDomains = domains.iterator();
//
//        while( iDomains.hasNext() ){
//            Person domain = (Person)iDomains.next();
//            json.setId(domain.getId());
//            json.setFullname(domain.getFirstName() + " " + domain.getLastName());
//            jsons.add(json);
//        }
//
//        PersonJsonList lJson = new PersonJsonList();
//        lJson.setPersonJson(jsons);
//        return lJson;
//    }
//
//    public CustomerJsonList createCustomer(List<Customer> domains) {
//        Customer        json = new Customer();
//        List<Customer> jsons = new ArrayList<Customer>();
//        Iterator      iDomains = domains.iterator();
//
//        while( iDomains.hasNext() ){
//            Customer domain = (Customer)iDomains.next();
//            json.setCustomerNumber(domain.getCustomerNumber());
//            json.setCustomerName(domain.getCustomerName());
//            json.setContactLastName(domain.getContactLastName());
//            json.setContactFirstName(domain.getContactFirstName());
//            json.setAddressLine1(domain.getAddressLine1());
//            json.setAddressLine2(domain.getAddressLine2());
//            json.setCity(domain.getCity());
//            json.setState(domain.getState());
//            json.setPostalCode(domain.getPostalCode());
//            json.setCountry(domain.getCountry());
//            json.setSalesRepEmployeeNumber(domain.getSalesRepEmployeeNumber());
//            json.setCreditLimit(domain.getCreditLimit());
//            jsons.add(json);
//        }
//
//        CustomerJsonList lJson = new CustomerJsonList();
//        lJson.setCustomerJson(jsons);
//        return lJson;
//    }
//
//    public Product createProduct(Product domain) {
//        return new Product(domain);
//    }
//
//    public ProductJson createProduct(String status, String message, List<Product> domains) {
//        ProductJson lJson = new ProductJson();
//        lJson.setStatus(status);
//        lJson.setMessage(message);
//        lJson.setData(domains);
//        return lJson;
//    }
//}
