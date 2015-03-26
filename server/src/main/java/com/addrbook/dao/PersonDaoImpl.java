package com.addrbook.dao;

import com.addrbook.domain.Customer;
import com.addrbook.domain.Person;
import com.addrbook.exception.PersonNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.WebApplicationInitializer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonDaoImpl implements PersonDao {
	
	private static final Logger logger = LoggerFactory.getLogger(WebApplicationInitializer.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public PersonDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public Person findById(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		List<Person> list = jdbcTemplate.query("select * from person where id = :id", params, new PersonRowMapper());
		if (list.isEmpty()) {
			throw new PersonNotFoundException("No person found for id: " + id);
		} else {
			return list.get(0);
		}
	}

    /**
     *
     * @return List<Person>
     */
    public List<Person> getAllPersons(){
        List<Person> list = jdbcTemplate.query("select * from person", new PersonRowMapper());
        if (list.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        } else {
            return list;
        }
    }

    public Customer getCustomer(){
        List<Customer> list = jdbcTemplate.query("select * from customers where customerNumber = 112", new CustomerRowMapper());
        if (list.isEmpty()) {
            throw new PersonNotFoundException("No person found for id: 112");
        } else {
            return list.get(0);
        }
    }
    public List<Customer> getAllCustomers(){
        List<Customer> list = jdbcTemplate.query("select * from customers", new CustomerRowMapper());
        if (list.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        } else {
            return list;
        }
    }

	public void insert(Person person) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		logger.debug("inserting person into database");
		jdbcTemplate.update(
				"insert into person (user_name, first_name, last_name) values (:userName, :firstName, :lastName)",
				new BeanPropertySqlParameterSource(person), keyHolder);

		Integer newId = keyHolder.getKey().intValue();

		// populate the id
		person.setId(newId);
	}

	public void update(Person person) {
		int numRowsAffected = jdbcTemplate.update(
				"update person set user_name = :userName, first_name = :firstName, last_name = :lastName where id = :id",
				new BeanPropertySqlParameterSource(person));
		
		if (numRowsAffected == 0) {
			throw new PersonNotFoundException("No person found for id: " + person.getId());
		}
	}

	private static class PersonRowMapper implements RowMapper<Person> {
		public Person mapRow(ResultSet res, int rowNum) throws SQLException {
			Person p = new Person();
			p.setId(res.getInt("id"));
			p.setUserName(res.getString("user_name"));
			p.setFirstName(res.getString("first_name"));
			p.setLastName(res.getString("last_name"));
			return p;
		}
	}

    private static class CustomerRowMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet res, int rowNum) throws SQLException {
            Customer c = new Customer();
            c.setCustomerNumber(res.getInt("customerNumber"));
            c.setCustomerName(res.getString("customerName"));
            c.setContactLastName(res.getString("contactLastName"));
            c.setContactFirstName(res.getString("contactFirstName"));
            c.setAddressLine1(res.getString("addressLine1"));
            c.setAddressLine2(res.getString("addressLine2"));
            c.setCity(res.getString("city"));
            c.setState(res.getString("state"));
            c.setPostalCode(res.getString("postalCode"));
            c.setCountry(res.getString("country"));
            c.setSalesRepEmployeeNumber(res.getInt("salesRepEmployeeNumber"));
            c.setCreditLimit(res.getDouble("creditLimit"));
            return c;
        }
    }

}
