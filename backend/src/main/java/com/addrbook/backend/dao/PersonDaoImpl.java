package com.addrbook.backend.dao;

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

    public void update(TomcatUsers user) {
        int numRowsAffected = jdbcTemplate.update(
                "update tomcat_users set user_pass = :userPass, user_fio = :userFio, email = :email, group_name = :groupName, update_ip = :updateIp, update_regdate = :updateRegdate, status = :status where user_name = :userName",
                new BeanPropertySqlParameterSource(user));

        if (numRowsAffected == 0) {
            throw new PersonNotFoundException("No user found for userName: " + user.getUserName());
        }
    }

    public void insert(TomcatUsers user) {
        logger.debug("inserting user into database");

        jdbcTemplate.update(
                "insert into tomcat_users (user_name, user_pass, user_fio, user_ldap, email, group_name, ip, regdate, status) values (:userName, :userPass, :userFio, :userLdap, :email, :groupName, :ip, :regdate, :status)",
                new BeanPropertySqlParameterSource(user));

        // populate the userName
        user.setUserName(user.getUserName());
    }

    public void delete(String userName) {
        String SQL = "DELETE FROM tomcat_users WHERE user_name = :userName";
        SqlParameterSource namedParameters = new MapSqlParameterSource("userName", userName);
        jdbcTemplate.update(SQL, namedParameters);
        System.out.println("Deleted user into database with userName = " + userName);
    }

    private static class UserRowMapper implements RowMapper<TomcatUsers> {
        public TomcatUsers mapRow(ResultSet res, int rowNum) throws SQLException {
            TomcatUsers u = new TomcatUsers();
            u.setUserName( res.getString("user_name") );
            u.setUserPass( res.getString("user_pass") );
            u.setUserFio( res.getString("user_fio") );
            u.setUserLdap( res.getString("user_ldap") );
            u.setEmail( res.getString("email") );
            u.setGroupName( res.getString("group_name") );
            u.setIp( res.getString("ip") );
            u.setUpdateIp( res.getString("update_ip") );
            u.setRegdate( res.getDate("regdate") );
            u.setUpdateRegdate( res.getDate("update_regdate"));
            u.setStatus(res.getString("status"));
            return  u;
        }
    }

}
