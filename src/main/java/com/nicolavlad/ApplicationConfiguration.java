package com.nicolavlad;

import com.nicolavlad.dao.EmployeeDao;
import com.nicolavlad.dao.EmployeeDaoImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImplementation(
                "postgresql",
                "localhost",
                "5432",
                "salariiApp",
                "postgres",
                "nicola1989");
    }

    @Bean
    public DataSource dataSource() {
        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append("5432")
                .append("/")
                .append("salariiApp")
                .append("?user=")
                .append("postgres")
                .append("&password=")
                .append("nicola1989").toString();
        return new SingleConnectionDataSource(url, false);
    }

}

