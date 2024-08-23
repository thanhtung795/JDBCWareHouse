package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class JpaHelper {
    private static final String dburl = "jdbc:mysql://localhost:3306/warehouseVitamin";
    private static final String username = "root";
    private static final String password = "tung123";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, username, password);
    }

    public static PreparedStatement preparedStatement(String sql, Object... args) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = conn.prepareCall(sql); //proc
        } else {
            pstmt = conn.prepareStatement(sql); //SQL
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static ResultSet executeQuery(String sql, Object... args){
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                conn.setAutoCommit(false);
                ResultSet rs = pstmt.executeQuery();
                conn.commit();
                return rs;
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException("Error executing query", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error", e);
        }
    }


    public static void executeUpdate(String sql, Object... args) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = preparedStatement(sql, args)) {
            try {
                conn.setAutoCommit(false);
                pstmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException("Error executing update", e);
            }
        } catch (SQLException e) {

            throw new RuntimeException("Error executing update", e);
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dburl, username, password);
            System.out.println("Connected to database");
        }catch (Exception e){
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }
}
