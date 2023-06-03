package com.ibank.service.utilities;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConnectionFactory {
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.username}")
	private String dbUserName;
	
	@Value("${db.password}")
	private String dbPassword;
	
	public HikariConfig getHikariConfig(String dbUrl,String dbUserName,String dbPassword) {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl(dbUrl);
		hikariConfig.setUsername(dbUserName);
		hikariConfig.setPassword(dbPassword);
		return hikariConfig;		
	}
	
	@Bean("dbDataSource")
	public DataSource dbConnectionInstance() {
		HikariConfig dbHikariConfig = getHikariConfig(dbUrl,dbUserName,dbPassword);
		return new HikariDataSource(dbHikariConfig);
	}
	
	public PlatformTransactionManager getTransactionManager(DataSource dbDataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dbDataSource);
		return transactionManager;
	}
	
	@Bean("dbTransactionManager")
	public PlatformTransactionManager getDbTransactionManager(@Qualifier("dbDataSource") DataSource dbDataSource) {
		return getTransactionManager(dbDataSource);
	}
	
	@Bean("dbJdbcTemplate")
	@Autowired
	public JdbcTemplate getDbJdbcTemplate(@Qualifier("dbDataSource") DataSource dbDataSource) {
		return new JdbcTemplate(dbDataSource);
	}
	
	@Bean("dbNamedParameterJdbcTemplate")
	@Autowired
	public NamedParameterJdbcTemplate getDbNamedParameterJdbcTemplate(@Qualifier("dbDataSource") DataSource dbDataSource) {
		return new NamedParameterJdbcTemplate(dbDataSource);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
