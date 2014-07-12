package com.anhvurz90.blacklisteddomain.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hsqldb.jdbcDriver;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.anhvurz90.blacklisteddomain.api.DomainManager;
import com.anhvurz90.blacklisteddomain.entities.Domain;

public class HsqlDomainManagerImpl implements DomainManager {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public HsqlDomainManagerImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			jdbcTemplate.execute("create table domain "
					+ "(id int not null identity, value varchar(45), primary key(id));");
		} catch (DataAccessException e) {
			// log
		}
	}

	@Override
  public void addDomain(Domain domain) {
		 String SQL = "insert into domain (value) values (?)";
		 jdbcTemplate.update(SQL, domain.getValue());
  }

	@Override
  public void removeDomain(Domain domain) {
		 String SQL = "delete from domain where value = ?";
		 jdbcTemplate.update(SQL, domain.getValue());
  }

	@Override
  public void removeDomain(String domainName) {
		 String SQL = "delete from domain where value = ?";
		 jdbcTemplate.update(SQL, domainName);
  }

	@Override
  public List<Domain> getAllDomains() {
		String SQL = "select * from domain";
		return jdbcTemplate.query(SQL, new DomainMapper());
  }

	@Override
  public boolean isBlacklisted(String email) {
	  return getAllDomains().contains(new Domain(email.substring(email.indexOf("@") + 1)));
  }

	@Override
  public void clear() {
		 String SQL = "delete from domain";
		 jdbcTemplate.update(SQL);
  }
	
	class DomainMapper implements RowMapper<Domain> {

		@Override
    public Domain mapRow(ResultSet rs, int rowNum) throws SQLException {
			Domain ret = new Domain();
			ret.setId(rs.getInt("id"));
			ret.setValue(rs.getString("value"));
			return ret;
    }
		
	}

}
