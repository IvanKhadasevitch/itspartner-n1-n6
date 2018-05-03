package net.itspartner.test.n5;

import java.sql.*;

/**
 * Description: Application makes request to MySQL DB to get record by id
 * Task: Implement SQL Injection Attack for getById method to change query logic.
 * Do not change 'getById' method code.
 * Attack should work for MySQL 5.7
 * Implement code that has protection from SQL Injection.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        getById("1"); // TODO Add SQL Injection Attack here

        getById("1 OR 'x'='x");
    }

    public static void getById(String id) throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root");
        Statement stmt = c.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM User WHERE id = '" + id + "'");

        while (resultSet.next()) {
            System.out.println(resultSet.getRow());
        }
    }

    public static void getByIdPS(String id) throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root");
        PreparedStatement ps = c.prepareStatement("SELECT * FROM  User WHERE id =?");
        ps.setString(1, id);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getRow());
        }
    }
}
