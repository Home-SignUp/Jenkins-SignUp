package com.addrbook.backend.dao;

import com.addrbook.backend.domain.Product;
import com.addrbook.backend.domain.TomcatUsers;
import com.addrbook.backend.exception.PersonNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
//    private static final String         sdftPattern = "HH:mm:ss";
//    private static final String         sdfdPattern = "yyyy-MM-dd";
//    private static final String        sdftsPattern = "yyyy-MM-dd HH:mm:ss.";
//    private static final String     sdftsSysPattern = "yyyy-MM-dd HH:mm:ss.SSS";
//    private static   DateFormat                  df = new SimpleDateFormat(sdfdPattern);

	@Autowired
	public PersonDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

    public Product findProductById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        List<Product> list = jdbcTemplate.query("select * from products where id = :id", params, new ProductRowMapper());
        if (list.isEmpty()) {
            throw new PersonNotFoundException("No product found for id: " + id);
        } else {
            return list.get(0);
        }
    }

    public TomcatUsers findUserById(String userName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);

        List<TomcatUsers> list = jdbcTemplate.query("select * from tomcat_users where user_name = :userName", params, new UserRowMapper());
        if (list.isEmpty()) {
            throw new PersonNotFoundException("No user found for userName: " + userName);
        } else {
            return list.get(0);
        }
    }

    /**
     *
     * @return List<Product>
     */
    public List<Product> getAllProducts(){
        List<Product> list = jdbcTemplate.query("select * from products", new ProductRowMapper());
        if (list.isEmpty()) {
            throw new PersonNotFoundException("No product found");
        } else {
            return list;
        }
    }

    /**
     *
     * @return List<TomcatUsers>
     */
    public List<TomcatUsers> getAllUsers(){
        List<TomcatUsers> list = jdbcTemplate.query("select * from tomcat_users", new UserRowMapper());
        if (list.isEmpty()) {
            throw new PersonNotFoundException("No user found");
        } else {
            return list;
        }
    }

    public void update(Product product) {
        int numRowsAffected = jdbcTemplate.update(
                "update products set status = :status, name = :name, description = :description, price = :price, stock = :stock, packing = :packing where id = :id",
                new BeanPropertySqlParameterSource(product));

        if (numRowsAffected == 0) {
            throw new PersonNotFoundException("No product found for id: " + product.getId());
        }
    }

    public void update(TomcatUsers user) {
        int numRowsAffected = jdbcTemplate.update(
                "update tomcat_users set user_name = :userName, user_pass = :userPass, user_fio = :userFio, user_ldap = :userLdap, email = :email, group_name = :groupName, ip = :ip, update_ip = :updateIp, regdate = :regdate, update_regdate = :updateRegdate where user_name = :userName",
                new BeanPropertySqlParameterSource(user));

        if (numRowsAffected == 0) {
            throw new PersonNotFoundException("No user found for userName: " + user.getUserName());
        }
    }

    public void insert(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        logger.debug("inserting product into database");

        jdbcTemplate.update(
                "insert into products (status, name, description, price, stock, packing, sku, mrp, category) values (:status, :name, :description, :price, :stock, :packing, :sku, :mrp, :category)",
                new BeanPropertySqlParameterSource(product), keyHolder);

        Integer newId = keyHolder.getKey().intValue();

        // populate the id
        product.setId(newId);
    }

    public void insert(TomcatUsers user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        logger.debug("inserting user into database");

        jdbcTemplate.update(
                "insert into tomcat_users (user_name, user_pass, user_fio, user_ldap, email, group_name, ip, update_ip, regdate, update_regdate) values (:userName, :userPass, :userFio, :userLdap, :email, :groupName, :ip, :updateIp, :regdate, :updateRegdate)",
                new BeanPropertySqlParameterSource(user), keyHolder);

        String newUserName = String.valueOf( keyHolder.getKey().intValue() );

        // populate the userName
        user.setUserName(newUserName);
    }

    public void delete(Integer id) {
        String SQL = "DELETE FROM products WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
        jdbcTemplate.update(SQL, namedParameters);
        System.out.println("Deleted product into database with ID = " + id);
    }

    public void delete(String userName) {
        String SQL = "DELETE FROM tomcat_users WHERE user_name = :userName";
        SqlParameterSource namedParameters = new MapSqlParameterSource("userName", userName);
        jdbcTemplate.update(SQL, namedParameters);
        System.out.println("Deleted user into database with userName = " + userName);
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        public Product mapRow(ResultSet res, int rowNum) throws SQLException {
            Product p = new Product();
            p.setId(res.getInt("id"));
            p.setSku(res.getInt("sku"));
            p.setName(res.getString("name"));
            p.setPrice(res.getDouble("price"));
            p.setMrp(res.getDouble("mrp"));
            p.setDescription(res.getString("description"));
            p.setPacking(res.getString("packing"));
            p.setImage(res.getString("image"));
            p.setCategory(res.getInt("category"));
            p.setStock(res.getInt("stock"));
            p.setStatus(res.getString("status"));
            return  p;
        }
    }

    private static class UserRowMapper implements RowMapper<TomcatUsers> {
        public TomcatUsers mapRow(ResultSet res, int rowNum) throws SQLException {
            TomcatUsers tu = new TomcatUsers();
            tu.setUserName( res.getString("user_name") );
            tu.setUserPass( res.getString("user_pass") );
            tu.setUserFio( res.getString("user_fio") );
            tu.setUserLdap( res.getString("user_ldap") );
            tu.setEmail( res.getString("email") );
            tu.setGroupName( res.getString("group_name") );
            tu.setIp( res.getString("ip") );
            tu.setUpdateIp( res.getString("update_ip") );
            tu.setRegdate( res.getDate("regdate") );
            tu.setUpdateRegdate( res.getDate("update_regdate"));
            return  tu;
        }
    }

}
