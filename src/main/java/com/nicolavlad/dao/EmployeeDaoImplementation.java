package com.nicolavlad.dao;

import com.nicolavlad.domain.Employee;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaoImplementation implements EmployeeDao {

    private String dbType;
    private String host;
    private String port;
    private String dbName;
    private String user;
    private String password;

    public EmployeeDaoImplementation(String dbType, String host, String port, String dbName, String user, String password) {
        this.dbType = dbType;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }

    private static Connection newConnection(String dbType, String host, String port, String dbName, String user, String password) {
        loadDriver();
        DriverManager.setLoginTimeout(60);
        try {
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append(dbType)
                    .append("://")
                    .append(host)
                    .append(":")
                    .append(port)
                    .append("/")
                    .append(dbName)
                    .append("?user=")
                    .append(user)
                    .append("&password=")
                    .append(password)
                    .toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        return null;
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can't load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> result = new LinkedList<>();
        try(
                Connection connection = newConnection(dbType, host, port, dbName, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from employees")
        ) {
            while (resultSet.next()) {
                Employee e = new Employee();
                e.setPrenume(resultSet.getString(1));
                e.setNume(resultSet.getString(2));
                e.setSalariuBrut(resultSet.getFloat(3));
                e.setCas(resultSet.getFloat(4));
                e.setSanatate(resultSet.getFloat(5));
                e.setSomaj(resultSet.getFloat(6));
                e.setSalariuNet(resultSet.getFloat(7));
                e.setId(resultSet.getInt(8));
                result.add(e);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public List<Employee> getById(int id) {
        List<Employee> result = new LinkedList<>();
        try(
                Connection connection = newConnection(dbType, host, port, dbName, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from employees where id=" + id)
        ) {
            while (resultSet.next()) {
                Employee e = new Employee();
                e.setPrenume(resultSet.getString(1));
                e.setNume(resultSet.getString(2));
                e.setSalariuBrut(resultSet.getFloat(3));
                e.setCas(resultSet.getFloat(4));
                e.setSanatate(resultSet.getFloat(5));
                e.setSomaj(resultSet.getFloat(6));
                e.setSalariuNet(resultSet.getFloat(7));
                e.setId(resultSet.getInt(8));
                result.add(e);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public void deleteById(int id) {
        try(
                Connection connection = newConnection(dbType, host, port, dbName, user, password);
                Statement statement = connection.createStatement()
        ) {
            statement.execute("delete from employees where id = " + id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void create(Employee e) {
        try(
                Connection connection = newConnection(dbType, host, port, dbName, user, password);
                Statement statement = connection.createStatement()
        ) {
            calculateTaxes(e);
            statement.execute("insert into employees values ('" + e.getPrenume() + "', '" + e.getNume() + "', " + e.getSalariuBrut() + ", " + e.getCas() + ", " + e.getSanatate() + ", " + e.getSomaj() + ", " + e.getSalariuNet() + ")");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void calculateTaxes(Employee employee) {
        employee.setCas((float) (employee.getSalariuBrut() * 0.105));
        employee.setSanatate((float) (employee.getSalariuBrut() * 0.055));
        employee.setSomaj((float) (employee.getSalariuBrut() * 0.005));
        employee.setSalariuNet(employee.getSalariuBrut() - employee.getCas() - employee.getSanatate() - employee.getSomaj());
    }

}
